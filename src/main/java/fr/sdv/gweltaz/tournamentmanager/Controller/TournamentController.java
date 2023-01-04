package fr.sdv.gweltaz.tournamentmanager.Controller;

import fr.sdv.gweltaz.tournamentmanager.DTO.*;
import fr.sdv.gweltaz.tournamentmanager.Exception.IdMismatchException;
import fr.sdv.gweltaz.tournamentmanager.Exception.NoWinnerException;
import fr.sdv.gweltaz.tournamentmanager.Exception.ResourceNotFoundException;
import fr.sdv.gweltaz.tournamentmanager.Service.TeamService;
import fr.sdv.gweltaz.tournamentmanager.Service.TournamentService;
import fr.sdv.gweltaz.tournamentmanager.mapper.TournamentMapper;
import fr.sdv.gweltaz.tournamentmanager.model.StateTournament;
import fr.sdv.gweltaz.tournamentmanager.model.Team;
import fr.sdv.gweltaz.tournamentmanager.model.Tournament;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/tournaments", produces = APPLICATION_JSON_VALUE)
public class TournamentController {
    private final TournamentMapper mapper;
    private final TournamentService service;
    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<PageDto<TournamentWithStatsDTO>> getTournaments(
            @RequestParam(required = false) String type,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize
    ) {
        if(Objects.isNull(type))
            return ResponseEntity.ok(this.mapper.pageToPagedTournamentsWithStatsDTO(this.service.getAllTournament(null, PageRequest.of(page, pageSize))));
        return ResponseEntity.ok(this.mapper.pageToPagedTournamentsWithStatsDTO(this.service.getTournamentByType(type, PageRequest.of(page, pageSize))));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TournamentWithStatsDTO> getTournamentDetails(@PathVariable(name = "id") Long id) {
        return this.service
                .getById(id)
                .map(this.mapper::tournamentToTournamentWithStatsDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Tournament", id));
    }

    @PostMapping
    public ResponseEntity<TournamentDTO> createTournament(@RequestBody TournamentCreateDTO dto) {
        Tournament tournament = this.mapper.tournamentCreateDTOToTournament(dto);
        Tournament createdTournament = this.service.save(tournament);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.mapper.tournamentToTournamentDTO(createdTournament));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TournamentDTO> updateTournament(@PathVariable Long id, @RequestBody TournamentDTO dto) {
        Optional<Tournament> optionalTournament = this.service.getById(id);
        if (optionalTournament.isEmpty()) throw new ResourceNotFoundException("Tournament", id);
        if (!Objects.equals(id, dto.id())) throw new IdMismatchException(id, dto.id());

        Tournament tournament = optionalTournament.get();
        tournament.setType(dto.type());
        tournament.setName(dto.name());
        tournament.setDescription(dto.description());
        tournament.setState(dto.state());
        tournament.setDate(dto.date());
        if (Objects.nonNull(dto.winner())) {
            Optional<Team> optionalWinner = this.teamService.getById(dto.winner().id());
            optionalWinner.ifPresent(tournament::setWinner);
        }
        List<Team> teams = new ArrayList<>();
        for (TeamNoRelationsDTO team : dto.teams()) {
            teamService.getById(team.id()).ifPresent(teams::add);
        }

        tournament.setTeams(teams);
        Tournament updatedTournament = this.service.save(tournament);
        return ResponseEntity.ok(mapper.tournamentToTournamentDTO(updatedTournament));
    }

    @PatchMapping(path = "/{id}/change-status")
    public ResponseEntity<TournamentDTO> changeStatus(@PathVariable Long id, @RequestBody TournamentStateUpdateDTO dto)
    {
        Optional<Tournament> optionalTournament = this.service.getById(id);
        if(optionalTournament.isEmpty()) throw new ResourceNotFoundException("Tournament", id);
        Tournament tournament = optionalTournament.get();
        if(dto.state() == StateTournament.ENDED){
            if(Objects.isNull(dto.winner())) throw new NoWinnerException();
            Optional<Team> optionalTeam = this.teamService.getById(dto.winner().id());
            if(optionalTeam.isEmpty()) throw new ResourceNotFoundException("Team", dto.winner().id());
            tournament.setWinner(optionalTeam.get());
        }
        tournament.setState(dto.state());
        Tournament patchedTournament = this.service.save(tournament);
        return ResponseEntity.ok(mapper.tournamentToTournamentDTO(patchedTournament));
    }
}
