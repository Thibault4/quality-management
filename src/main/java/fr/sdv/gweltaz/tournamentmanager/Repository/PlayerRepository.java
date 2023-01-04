package fr.sdv.gweltaz.tournamentmanager.Repository;

import fr.sdv.gweltaz.tournamentmanager.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Page<Player> findAll(Pageable page);
    Page<Player> findAllByName(String name, Pageable page);
}