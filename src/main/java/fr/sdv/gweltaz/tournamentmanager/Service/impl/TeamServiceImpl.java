package fr.sdv.gweltaz.tournamentmanager.Service.impl;

import fr.sdv.gweltaz.tournamentmanager.Repository.TeamRepository;
import fr.sdv.gweltaz.tournamentmanager.Service.TeamService;
import fr.sdv.gweltaz.tournamentmanager.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    public final TeamRepository teamRepository;

    public Page<Team> getAllTeams(String name, PageRequest page) {
        if (name == null) {
            return teamRepository.findAll(page);
        } else {
            return teamRepository.findAllByName(name, page);
        }
    }

}



