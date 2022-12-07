package fr.sdv.gweltaz.tournamentmanager.DTO;

import java.io.Serializable;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Player} entity
 */
public record PlayerCreateDTO(String name, String address) implements Serializable
{
}