package service.simpleservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.simpleservice.domain.Modification;

import java.util.List;

public interface ModificationRepository extends JpaRepository<Modification, Long> {
    List<Modification> findByBeginPeriodAndEndPeriodBetween(int beginPeriod, int endPeriod, int endPeriod2);

}
