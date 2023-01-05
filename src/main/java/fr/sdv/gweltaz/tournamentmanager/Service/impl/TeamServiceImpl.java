package fr.sdv.gweltaz.tournamentmanager.Service.impl;

import fr.sdv.gweltaz.tournamentmanager.Repository.TeamRepository;
import fr.sdv.gweltaz.tournamentmanager.Service.TeamService;
import fr.sdv.gweltaz.tournamentmanager.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    public final TeamRepository teamRepository;

    public Page<Team> getAllTeams(PageRequest page) {
        return teamRepository.findAll(page);
    }

    public Optional<Team> getById(Long id) {
        return this.teamRepository.findById(id);
    }

    public Team save(Team team) {
        return this.teamRepository.save(team);
    }
}



