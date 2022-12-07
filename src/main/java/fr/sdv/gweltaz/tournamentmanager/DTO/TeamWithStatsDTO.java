package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Team} entity
 */
@Builder
public record TeamWithStatsDTO(
        Long id, String name,
        Integer tournamentsWon,
        Integer tournamentsRegisteredIn,
        Long tournamentsPlanned,
        Long tournamentsPlayed,
        Long tournamentsCurrentlyIn
)
{
}
