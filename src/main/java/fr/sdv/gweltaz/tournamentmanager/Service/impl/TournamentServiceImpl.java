package fr.sdv.gweltaz.tournamentmanager.Service.impl;

import fr.sdv.gweltaz.tournamentmanager.Repository.TournamentRepository;
import fr.sdv.gweltaz.tournamentmanager.Service.TournamentService;
import fr.sdv.gweltaz.tournamentmanager.model.Tournament;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {
    public final TournamentRepository tournamentRepository;

    public Page<Tournament> getAllTournament(String name, PageRequest page){
        if (name == null) {
            return tournamentRepository.findAll(page);
        } else {
            return tournamentRepository.findAllByName(name, page);
        }
    }

    public Page<Tournament> getTournamentByType(String type, PageRequest page){
        if (type == null) {
            return tournamentRepository.findAll(page);
        } else {
            return tournamentRepository.findAllByType(type, page);
        }
    }

    @Override
    public Optional<Tournament> getById(Long id) {
        return this.tournamentRepository.findById(id);
    }

    @Override
    public Tournament save(Tournament tournament) {
        return this.tournamentRepository.save(tournament);
    }
}
