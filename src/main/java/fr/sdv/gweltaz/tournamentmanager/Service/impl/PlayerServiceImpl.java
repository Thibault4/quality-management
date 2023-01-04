package fr.sdv.gweltaz.tournamentmanager.Service.impl;

import fr.sdv.gweltaz.tournamentmanager.Repository.PlayerRepository;
import fr.sdv.gweltaz.tournamentmanager.Service.PlayerService;
import fr.sdv.gweltaz.tournamentmanager.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    public final PlayerRepository playerRepository;

    @Override
    public Page<Player> getAllPlayers(String name, PageRequest page) {
        if (name == null) {
            return playerRepository.findAll(page);
        } else {
            return playerRepository.findAllByName(name, page);
        }
    }

}
