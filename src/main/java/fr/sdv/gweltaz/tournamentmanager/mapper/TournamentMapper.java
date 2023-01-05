package fr.sdv.gweltaz.tournamentmanager.mapper;

import fr.sdv.gweltaz.tournamentmanager.DTO.*;
import fr.sdv.gweltaz.tournamentmanager.model.Tournament;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {PageMapper.class})
public interface TournamentMapper
{
    Tournament tournamentIdDTOToTournament(TournamentIdDTO tournamentIdDTO);

    TournamentIdDTO tournamentToTournamentIdDTO(Tournament tournament);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tournament updateTournamentFromTournamentIdDTO(TournamentIdDTO tournamentIdDTO, @MappingTarget Tournament tournament);

    Tournament tournamentNoRelationsDTOToTournament(TournamentNoRelationsDTO tournamentNoRelationsDTO);

    TournamentNoRelationsDTO tournamentToTournamentNoRelationsDTO(Tournament tournament);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tournament updateTournamentFromTournamentNoRelationsDTO(TournamentNoRelationsDTO tournamentNoRelationsDTO, @MappingTarget Tournament tournament);


    Tournament tournamentDTOToTournament(TournamentDTO tournamentDTO);

    TournamentDTO tournamentToTournamentDTO(Tournament tournament);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tournament updateTournamentFromTournamentDTO(TournamentDTO tournamentDTO, @MappingTarget Tournament tournament);

    Tournament tournamentWithPlayersDTOToTournament(TournamentWithPlayersDTO tournamentWithPlayersDTO);

    TournamentWithPlayersDTO tournamentToTournamentWithPlayersDTO(Tournament tournament);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tournament updateTournamentFromTournamentWithPlayersDTO(TournamentWithPlayersDTO tournamentWithPlayersDTO, @MappingTarget Tournament tournament);

    @Mapping(target = "teams", expression = "java(tournament.getTeams().size())")
    @Mapping(target = "players", expression = "java(tournament.getNumberOfPlayers())")
    TournamentWithStatsDTO tournamentToTournamentWithStatsDTO(Tournament tournament);

    Tournament tournamentCreateDTOToTournament(TournamentCreateDTO tournamentCreateDTO);

    TournamentCreateDTO tournamentToTournamentCreateDTO(Tournament tournament);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tournament updateTournamentFromTournamentCreateDTO(TournamentCreateDTO tournamentCreateDTO, @MappingTarget Tournament tournament);

    @Mapping(target = "data", source = "content")
    @Mapping(target = "context", source = ".")
    PageDto<TournamentWithStatsDTO> pageToPagedTournamentsWithStatsDTO(Page<Tournament> page);

    @Mapping(target = "data", source = "content")
    @Mapping(target = "context", source = ".")
    PageDto<TournamentDTO> pageToPagedTournamentsDTO(Page<Tournament> page);
}
