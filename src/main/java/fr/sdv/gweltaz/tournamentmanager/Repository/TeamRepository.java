package fr.sdv.gweltaz.tournamentmanager.Repository;


import fr.sdv.gweltaz.tournamentmanager.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<Team, Long> {
    Page<Team> findAll(Pageable page);
}