package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;

import java.io.Serializable;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Player} entity
 */
@Builder
public record PlayerWithStatsDTO(
        Long id,
        String name,
        String address,
        Integer teamsPlayedIn,
        Integer tournamentsWon,
        Integer tournamentsRegisteredIn,
        Long tournamentsPlanned,
        Long tournamentsPlayed,
        Long tournamentsCurrentlyIn
) implements Serializable
{
}
