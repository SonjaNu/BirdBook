package palvelinohjelmointi.BirdWatchingBook.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BirdRepository extends CrudRepository<Bird, Long> {

    List<Bird> findByName(String name);
    Optional<Bird> findById(Long id);
    
}