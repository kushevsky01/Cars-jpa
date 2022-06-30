package service.simpleservice.repositories;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import service.simpleservice.domain.Search;

import java.util.List;

public interface SearchReposirory extends JpaRepository<Search, Long> {
}
