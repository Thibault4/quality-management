package fr.sdv.gweltaz.tournamentmanager.Controller;

import fr.sdv.gweltaz.tournamentmanager.DTO.PageDto;
import fr.sdv.gweltaz.tournamentmanager.DTO.PlayerCreateDTO;
import fr.sdv.gweltaz.tournamentmanager.DTO.PlayerDTO;
import fr.sdv.gweltaz.tournamentmanager.DTO.PlayerNameDTO;
import fr.sdv.gweltaz.tournamentmanager.Service.PlayerService;
import fr.sdv.gweltaz.tournamentmanager.mapper.PlayerMapper;
import fr.sdv.gweltaz.tournamentmanager.mapper.TeamMapper;
import fr.sdv.gweltaz.tournamentmanager.model.Player;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
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
@RequestMapping(path = "/v1/players", produces = APPLICATION_JSON_VALUE)
@SecurityRequirement(name = "tm")
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerMapper playerMapper;
    private final TeamMapper teamMapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_VISITOR','ROLE_ADMIN')")
    public ResponseEntity<PageDto<PlayerNameDTO>> getPlayers(@RequestParam(required = false) String name, @RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "5") int pageSize) {
        //Middleware.verifyAuth();
        return ResponseEntity.ok(playerMapper.mapToPageDTO(playerService.getAllPlayers(name, PageRequest.of(page, pageSize))));
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_VISITOR','ROLE_ADMIN')")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        //Middleware.verifyAuth();
        return ResponseEntity.of(playerService.getPlayer(id).map(this.playerMapper::playerToPlayerDTO));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerCreateDTO playerCreateDTO) {
        //Middleware.verifyAuthAdmin();
        Player player = this.playerMapper.playerCreateDTOToPlayer(playerCreateDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.playerMapper.playerToPlayerDTO(this.playerService.savePlayer(player)));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        //Middleware.verifyAuthAdmin();
        Optional<Player> player = playerService.getPlayer(id);
        if(player.isEmpty()) {
            return ResponseEntity.of(this.playerService.getPlayer(id).map(this.playerMapper::playerToPlayerDTO));
        }
        Player playerToUpdate = player.get();
        playerToUpdate.setName(playerDTO.name());
        playerToUpdate.setAddress(playerDTO.address());
        playerToUpdate.setTeams(this.teamMapper.listTeamNoRelationsDTOToListTeam(playerDTO.teams()));
        return ResponseEntity.ok(this.playerMapper.playerToPlayerDTO(this.playerService.savePlayer(playerToUpdate)));
    }
}
