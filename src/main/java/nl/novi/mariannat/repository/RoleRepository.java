package nl.novi.mariannat.repository;

import nl.novi.mariannat.domain.ERole;
import nl.novi.mariannat.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
