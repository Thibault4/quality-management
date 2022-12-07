package fr.sdv.gweltaz.tournamentmanager.DTO;

import fr.sdv.gweltaz.tournamentmanager.model.StateTournament;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Tournament} entity
 */
public record TournamentCreateDTO(String type, String name, String description, StateTournament state,
                                  Date date) implements Serializable
{
}