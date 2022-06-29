package service.simpleservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.simpleservice.domain.Modification;

public interface ModificationRepository extends JpaRepository<Modification, Long> {

}
