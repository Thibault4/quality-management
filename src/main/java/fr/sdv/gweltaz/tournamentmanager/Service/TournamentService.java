package fr.sdv.gweltaz.tournamentmanager.Service;

import fr.sdv.gweltaz.tournamentmanager.model.Tournament;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;

public interface TournamentService{
    Page<Tournament> getAllTournament(String name, PageRequest page);
    Page<Tournament> getTournamentByType(String type, PageRequest page);
    Page<Tournament> getTournamentByDate(Date date, PageRequest page);
}