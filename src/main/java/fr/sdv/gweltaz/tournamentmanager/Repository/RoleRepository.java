package fr.sdv.gweltaz.tournamentmanager.Repository;

import fr.sdv.gweltaz.tournamentmanager.model.Role;
import fr.sdv.gweltaz.tournamentmanager.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}