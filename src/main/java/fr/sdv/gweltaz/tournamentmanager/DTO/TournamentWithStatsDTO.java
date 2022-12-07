package fr.sdv.gweltaz.tournamentmanager.DTO;

import fr.sdv.gweltaz.tournamentmanager.model.StateTournament;
import lombok.Builder;

import java.util.Date;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Tournament} entity
 */
@Builder
public record TournamentWithStatsDTO(
        Long id,
        String type,
        String name,
        String description,
        StateTournament state,
        Date date,
        Integer teams,
        Integer players
)
{
}
