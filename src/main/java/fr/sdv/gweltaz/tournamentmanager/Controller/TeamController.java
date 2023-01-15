package fr.sdv.gweltaz.tournamentmanager.Controller;

import fr.sdv.gweltaz.tournamentmanager.DTO.PageDto;
import fr.sdv.gweltaz.tournamentmanager.DTO.TeamCreateDTO;
import fr.sdv.gweltaz.tournamentmanager.DTO.TeamWithPlayersDTO;
import fr.sdv.gweltaz.tournamentmanager.DTO.TeamWithStatsDTO;
import fr.sdv.gweltaz.tournamentmanager.Service.TeamService;
import fr.sdv.gweltaz.tournamentmanager.mapper.PlayerMapper;
import fr.sdv.gweltaz.tournamentmanager.mapper.TeamMapper;
import fr.sdv.gweltaz.tournamentmanager.model.Team;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/teams", produces = APPLICATION_JSON_VALUE)
@SecurityRequirement(name = "tm")
public class TeamController {
    private final TeamMapper teamMapper;
    private final PlayerMapper playerMapper;
    private final TeamService teamService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_VISITOR','ROLE_ADMIN')")
    public ResponseEntity<PageDto<TeamWithPlayersDTO>> getTeams(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize
    ) {
        //Middleware.verifyAuth();
        return ResponseEntity.ok(this.teamMapper.pageTeamWithPlayersDTOToPageTeamDTO(this.teamService.getAllTeams(PageRequest.of(page, pageSize))));
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_VISITOR','ROLE_ADMIN')")
    public ResponseEntity<TeamWithStatsDTO> getTeam(@PathVariable Long id) {
        //Middleware.verifyAuth();
        return ResponseEntity.of(this.teamService.getById(id).map(this.teamMapper::teamToTeamWithStatsDTO));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<TeamWithStatsDTO> createTeam(@RequestBody TeamCreateDTO teamCreateDTO) {
        //Middleware.verifyAuthAdmin();
        Team team = this.teamMapper.teamCreateDTOToTeam(teamCreateDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.teamMapper.teamToTeamWithStatsDTO(this.teamService.save(team)));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<TeamWithStatsDTO> updateTeam(@PathVariable Long id, @RequestBody TeamWithPlayersDTO teamWithPlayersDTO) {
        //Middleware.verifyAuthAdmin();
        Optional<Team> teamOptional = this.teamService.getById(id);
        if(teamOptional.isEmpty()) {
            return ResponseEntity.of(this.teamService.getById(id).map(this.teamMapper::teamToTeamWithStatsDTO));
        }
        Team teamToUpdate = teamOptional.get();
        teamToUpdate.setName(teamWithPlayersDTO.name());
        teamToUpdate.setPlayers(this.playerMapper.listPlayerNoRelationsDTOToListPlayer(teamWithPlayersDTO.players()));
        return ResponseEntity.ok(this.teamMapper.teamToTeamWithStatsDTO(this.teamService.save(teamToUpdate)));
    }
}
