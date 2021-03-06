package nl.novi.mariannat.repository;


import nl.novi.mariannat.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoRepository  extends JpaRepository<Demo, Long> {
    List<Demo> findAllByUserId(Long userId);
}
