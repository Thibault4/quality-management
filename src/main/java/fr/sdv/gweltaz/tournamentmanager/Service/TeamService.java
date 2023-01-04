package fr.sdv.gweltaz.tournamentmanager.Service;

import fr.sdv.gweltaz.tournamentmanager.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface TeamService {
    Page<Team> getAllTeams(String name, PageRequest page);
}