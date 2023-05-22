package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Player} entity
 */
@Builder
public record PlayerWithTournamentsDTO(Long id, String name, String address, String firstName, Date birthDate, String postalCode, String city,
                                       List<TeamWithTournamentsDTO> teams) implements Serializable
{
}