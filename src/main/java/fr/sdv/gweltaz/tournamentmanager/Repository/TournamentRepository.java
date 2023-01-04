package fr.sdv.gweltaz.tournamentmanager.Repository;

import fr.sdv.gweltaz.tournamentmanager.model.Tournament;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Page<Tournament> findAll(Pageable page);
    Page<Tournament> findAllByType(String type, Pageable page);
    Page<Tournament> findAllByDate(Date date,Pageable page);
    Page<Tournament> findAllByName(String name, Pageable page);
}