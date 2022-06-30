package service.simpleservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.simpleservice.domain.Mark;


public interface MarkRepository extends JpaRepository<Mark, Long> {
    Mark findMarkByMarkName(String markName);
}
