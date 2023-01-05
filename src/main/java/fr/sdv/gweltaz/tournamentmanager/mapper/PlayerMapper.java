package fr.sdv.gweltaz.tournamentmanager.mapper;

import fr.sdv.gweltaz.tournamentmanager.DTO.*;
import fr.sdv.gweltaz.tournamentmanager.model.Player;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PlayerMapper
{
    Player playerIdDTOToPlayer(PlayerIdDTO playerIdDTO);

    PlayerIdDTO playerToPlayerIdDTO(Player player);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Player updatePlayerFromPlayerIdDTO(PlayerIdDTO playerIdDTO, @MappingTarget Player player);

    Player playerNoRelationsDTOToPlayer(PlayerNoRelationsDTO playerNoRelationsDTO);

    PlayerNoRelationsDTO playerToPlayerNoRelationsDTO(Player player);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Player updatePlayerFromPlayerNoRelationsDTO(PlayerNoRelationsDTO playerNoRelationsDTO, @MappingTarget Player player);

    Player playerDTOToPlayer(PlayerDTO playerDTO);

    PlayerDTO playerToPlayerDTO(Player player);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Player updatePlayerFromPlayerDTO(PlayerDTO playerDTO, @MappingTarget Player player);

    @Mapping(target = "teamsPlayedIn", expression = "java(player.getTeams().size())")
    @Mapping(target = "tournamentsWon", expression = "java(player.getNumberOfTournamentsWon())")
    @Mapping(target = "tournamentsPlanned", expression = "java(player.getNumberOfTournamentsPlanned())")
    @Mapping(target = "tournamentsPlayed", expression = "java(player.getNumberOfTournamentsPlayed())")
    @Mapping(target = "tournamentsCurrentlyIn", expression = "java(player.getNumberOfTournamentsCurrentlyIn())")
    @Mapping(target = "tournamentsRegisteredIn", expression = "java(player.getNumberOfTournamentsRegisteredIn())")
    PlayerWithStatsDTO playerToPlayerWithStatsDTO(Player player);

    Player playerWithTournamentsDTOToPlayer(PlayerWithTournamentsDTO playerWithTournamentsDTO);

    PlayerWithTournamentsDTO playerToPlayerWithTournamentsDTO(Player player);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Player updatePlayerFromPlayerWithTournamentsDTO(PlayerWithTournamentsDTO playerWithTournamentsDTO, @MappingTarget Player player);

    Player playerCreateDTOToPlayer(PlayerCreateDTO playerCreateDTO);

    PlayerCreateDTO playerToPlayerCreateDTO(Player player);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Player updatePlayerFromPlayerCreateDTO(PlayerCreateDTO playerCreateDTO, @MappingTarget Player player);

    List<Player> listPlayerNoRelationsDTOToListPlayer(List<PlayerNoRelationsDTO> playerNoRelationsDTOS);

    PageDto<PlayerNameDTO> mapToPageDTO(Page<Player> page);
}
