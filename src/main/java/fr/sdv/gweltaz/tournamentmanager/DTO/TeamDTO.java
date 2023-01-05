package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Team} entity
 */
@Builder
public record TeamDTO(Long id, String name, List<PlayerNoRelationsDTO> players,
                      List<TournamentNoRelationsDTO> tournaments,
                      List<TournamentNoRelationsDTO> tournamentsWon) implements Serializable
{
}