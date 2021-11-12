package palvelinohjelmointi.BirdWatchingBook.domain;

import java.util.List;




import org.springframework.data.repository.CrudRepository;

public interface BirdRepository extends CrudRepository<Bird, Long> {

    List<Bird> findByName(String name);
    
}