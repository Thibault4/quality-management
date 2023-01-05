package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Player} entity
 */
@Builder
public record PlayerDTO(Long id, String name, String address, List<TeamNoRelationsDTO> teams) implements Serializable
{
}