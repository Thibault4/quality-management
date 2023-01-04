package fr.sdv.gweltaz.tournamentmanager.Service;

import fr.sdv.gweltaz.tournamentmanager.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface PlayerService {
    Page<Player> getAllPlayers(String name, PageRequest page);
}