package palvelinohjelmointi.BirdWatchingBook;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
import palvelinohjelmointi.BirdWatchingBook.web.BirdController;
import palvelinohjelmointi.BirdWatchingBook.web.CategoryController;
import palvelinohjelmointi.BirdWatchingBook.web.FindingController;

//@RunWith(SpringRunner.class) // JUnit4
@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@SpringBootTest
class BirdWatchingApplicationTests {

	@Autowired
	private BirdController birdController;
	@Autowired
	private CategoryController categoryController;
	@Autowired
	private FindingController findingController;
	
	@Test
	public void contextLoads() {
	    assertThat(birdController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(findingController).isNotNull();
	}
	
}
