package palvelinohjelmointi.BirdWatchingBook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import palvelinohjelmointi.BirdWatchingBook.domain.Bird;
import palvelinohjelmointi.BirdWatchingBook.domain.BirdRepository;
import palvelinohjelmointi.BirdWatchingBook.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookstoreRepositoryTest {
	
    @Autowired
    private BirdRepository repository;

//    @Test  // testataan StudentRepositoryn findByLastName()-metodin toimivuutta
//    public void findByBookTitleShouldReturnBook() {
//    	List<Bird> birds = repository.findByTitle("Rivo satakieli");
//        
//        assertThat(birds).hasSize(1);
//        assertThat(birds.get(0).getAuthor()).isEqualTo("Leena Lehtolainen");
//    }
//    // (String title, String author, int year, String isbn, double price, Category category)
//    Category category = new Category("Romantiikka");
//    @Test // testataan StudentRepositoryn save()-metodin toimivuutta
//    public void createNewBook() {
//    	Bird bird = new Bird("Toscanan auringon alla", "Joku tyyppi", 1990, "bb124351", 9.90, category);
//    	repository.save(bird);
//    	assertThat(bird.getId()).isNotNull();
//    } 
//    @Test
//    public void deleteBook() {
//    	List<Bird> birds = repository.findByTitle("Toscanan auringon alla");
//    	repository.deleteAll(birds);
//    	
//    	assertThat(birds).hasSize(0);
//        
//    }
}
