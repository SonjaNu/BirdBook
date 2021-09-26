package palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import palvelinohjelmointi.Bookstore.BookstoreApplication;
import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;
import palvelinohjelmointi.Bookstore.domain.Category;
import palvelinohjelmointi.Bookstore.domain.CategoryRepository;

@SpringBootApplication

public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository) { //luo testidataa
		return (args) -> {
			
			Category category1 = new Category("Dekkarit");
			categoryRepository.save(category1);
			Category category2 = new Category("Romantiikka");
			categoryRepository.save(category2);
			Category category3 = new Category("Elämäkerrat");
			categoryRepository.save(category3);
			Category category4 = new Category("Runot");
			categoryRepository.save(category4);
			
			log.info("save a couple of books");
			repository.save(new Book("Eikä yksikään pelastunut", "Agatha Christie", 1993, "bb876567", 9.50));
			repository.save(new Book("Rivo satakieli", "Leena Lehtolainen", 2000, "bb789064", 15.90));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

		};
	}

	}


