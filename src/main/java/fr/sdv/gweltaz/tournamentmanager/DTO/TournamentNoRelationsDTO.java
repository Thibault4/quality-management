package fr.sdv.gweltaz.tournamentmanager.DTO;

import fr.sdv.gweltaz.tournamentmanager.model.StateTournament;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Tournament} entity
 */
@Builder
public record TournamentNoRelationsDTO(
        Long id,
        String type,
        String name,
        String description,
        StateTournament state,
        Date date
) implements Serializable
{
}