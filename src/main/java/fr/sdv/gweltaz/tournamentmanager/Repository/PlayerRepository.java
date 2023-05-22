package fr.sdv.gweltaz.tournamentmanager.Repository;

import fr.sdv.gweltaz.tournamentmanager.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Page<Player> findAll(Pageable page);
    Page<Player> findAllByNameAndFirstName(String name, String firstname, Pageable page);
    Optional<Player> findPlayerById(Long id);
    Player save(Player player);
}