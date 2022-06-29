package service.simpleservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.simpleservice.domain.Model;


public interface ModelRepository extends JpaRepository<Model, Long> {
}
