package palvelinohjelmointi.BirdWatchingBook;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import palvelinohjelmointi.BirdWatchingBook.domain.Bird;
import palvelinohjelmointi.BirdWatchingBook.domain.BirdRepository;
import palvelinohjelmointi.BirdWatchingBook.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BirdWatchingRepositoryTests {
	
    @Autowired
    private BirdRepository repository;

    Category category1 = new Category("Varpuslinnut");
    @Test // testataan BirdRepositoryn save()-metodin toimivuutta
    public void createNewBird() {
    	Bird bird = new Bird("Varpunen", "koko Suomi", "yleinen", category1);
    	repository.save(bird);
    	assertThat(bird.getId()).isNotNull();
    } 
    
    @Test  // testataan lintu repositoryn findByName()-metodin toimivuutta
    public void findByBirdNameShouldReturnBird() {
    	List<Bird> birds = repository.findByName("Varpunen");     
        assertThat(birds).hasSize(1);
        assertThat(birds.get(0).getRarity()).isEqualTo("yleinen");
    }
    
    @Test
    @Rollback(false)
    public void deleteBird() { //testataan toiminnon linnun poisto toimivuutta
    	Bird bird = repository.findById(Long.valueOf(5)).get();
    	repository.delete(bird);
    	Optional<Bird> deleteBird = repository.findById(Long.valueOf(0));
    	assertThat(deleteBird).isEmpty();

    }
    
   
}
