package service.simpleservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import service.simpleservice.domain.Mark;
import service.simpleservice.domain.Model;

import java.util.List;


public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findModelByModelName(String modelName);
}
