package fr.sdv.gweltaz.tournamentmanager.mapper;

import fr.sdv.gweltaz.tournamentmanager.DTO.*;
import fr.sdv.gweltaz.tournamentmanager.model.Team;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TeamMapper
{
    Team teamIdDTOToTeam(TeamIdDTO teamIdDTO);

    TeamIdDTO teamToTeamIdDTO(Team team);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team updateTeamFromTeamIdDTO(TeamIdDTO teamIdDTO, @MappingTarget Team team);

    Team teamNoRelationsDTOToTeam(TeamNoRelationsDTO teamNoRelationsDto);

    TeamNoRelationsDTO teamToTeamNoRelationsDTO(Team team);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team updateTeamFromTeamNoRelationsDTO(TeamNoRelationsDTO teamNoRelationsDto, @MappingTarget Team team);

    Team teamDTOToTeam(TeamDTO teamDTO);

    TeamDTO teamToTeamDTO(Team team);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team updateTeamFromTeamDTO(TeamDTO teamDTO, @MappingTarget Team team);

    @Mapping(target = "tournamentsWon", expression = "java(team.getTournamentsWon().size())")
    @Mapping(target = "tournamentsRegisteredIn", expression = "java(team.getTournaments().size())")
    @Mapping(target = "tournamentsPlanned", expression = "java(team.getNumberOfTournamentsPlanned())")
    @Mapping(target = "tournamentsPlayed", expression = "java(team.getNumberOfTournamentsPlayed())")
    @Mapping(target = "tournamentsCurrentlyIn", expression = "java(team.getNumberOfTournamentsCurrentlyIn())")
    TeamWithStatsDTO teamToTeamWithStatsDTO(Team team);

    @AfterMapping
    default void linkTournamentsWon(@MappingTarget Team team)
    {
        team.getTournamentsWon().forEach(tournamentsWon -> tournamentsWon.setWinner(team));
    }

    Team teamWithPlayersDTOToTeam(TeamWithPlayersDTO teamWithPlayersDTO);

    TeamWithPlayersDTO teamToTeamWithPlayersDTO(Team team);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team updateTeamFromTeamWithPlayersDTO(TeamWithPlayersDTO teamWithPlayersDTO, @MappingTarget Team team);

    Team teamWithTournamentsDTOToTeam(TeamWithTournamentsDTO teamWithTournamentsDTO);

    TeamWithTournamentsDTO teamToTeamWithTournamentsDTO(Team team);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team updateTeamFromTeamWithTournamentsDTO(TeamWithTournamentsDTO teamWithTournamentsDTO, @MappingTarget Team team);

    Team teamCreateDTOToTeam(TeamCreateDTO teamCreateDTO);

    TeamCreateDTO teamToTeamCreateDTO(Team team);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team updateTeamFromTeamCreateDTO(TeamCreateDTO teamCreateDTO, @MappingTarget Team team);
}
