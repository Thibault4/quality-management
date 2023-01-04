package fr.sdv.gweltaz.tournamentmanager.DTO;

import fr.sdv.gweltaz.tournamentmanager.model.StateTournament;

import java.io.Serializable;

public record TournamentStateUpdateDTO(Long id, StateTournament state, TeamIdDTO winner) implements Serializable {
}
