package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;

import java.io.Serializable;

/**
 * A DTO for the {@link fr.sdv.gweltaz.tournamentmanager.model.Tournament} entity
 */
@Builder
public record TournamentIdDTO(Long id) implements Serializable
{
}