package fr.sdv.gweltaz.tournamentmanager.Service;

import fr.sdv.gweltaz.tournamentmanager.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface TeamService {
    Page<Team> getAllTeams(String name, PageRequest page);

    Optional<Team> getById(Long id);
}