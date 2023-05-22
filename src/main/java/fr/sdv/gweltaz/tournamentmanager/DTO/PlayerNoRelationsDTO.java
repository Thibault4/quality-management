package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Player} entity
 */
@Builder
public record PlayerNoRelationsDTO(Long id, String name, String address, String firstName, Date birthDate, String postalCode, String city) implements Serializable
{
}