package fr.sdv.gweltaz.tournamentmanager.DTO;

import java.io.Serializable;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Team} entity
 */
public record TeamCreateDTO(String name) implements Serializable
{
}