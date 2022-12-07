package fr.sdv.gweltaz.tournamentmanager.DTO;

import fr.sdv.gweltaz.tournamentmanager.model.StateTournament;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Tournament} entity
 */
@Builder
public record TournamentDTO(Long id, String type, String name, String description, StateTournament state, Date date,
                            TeamNoRelationsDTO winner, List<TeamNoRelationsDTO> teams) implements Serializable
{
}