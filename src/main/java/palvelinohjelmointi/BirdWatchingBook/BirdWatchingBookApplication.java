package palvelinohjelmointi.BirdWatchingBook;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.BirdWatchingBook.BirdWatchingBookApplication;
import palvelinohjelmointi.BirdWatchingBook.domain.Bird;
import palvelinohjelmointi.BirdWatchingBook.domain.BirdRepository;
import palvelinohjelmointi.BirdWatchingBook.domain.Category;
import palvelinohjelmointi.BirdWatchingBook.domain.CategoryRepository;
import palvelinohjelmointi.BirdWatchingBook.domain.Finding;
import palvelinohjelmointi.BirdWatchingBook.domain.FindingRepository;
import palvelinohjelmointi.BirdWatchingBook.domain.User;
import palvelinohjelmointi.BirdWatchingBook.domain.UserRepository;


@SpringBootApplication

public class BirdWatchingBookApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BirdWatchingBookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BirdWatchingBookApplication.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner birdDemo(BirdRepository repository, CategoryRepository categoryRepository, UserRepository userRepository, FindingRepository findingRepository) { //luo testidataa
		return (args) -> {
			
		
			
			Category category1 = new Category("Varpuslinnut");
			categoryRepository.save(category1);
			Category category2 = new Category("Varislinnut");
			categoryRepository.save(category2);
			Category category3 = new Category("Lokit");
			categoryRepository.save(category3);
			Category category4 = new Category("Tiaiset");
			categoryRepository.save(category4);
			
			log.info("save a couple of birds");
			
			repository.save(new Bird("Harakka", "koko Suomi", "yleinen", category2));
			repository.save(new Bird("Varpunen", "koko Suomi", "yleinen", category1));
			
			Bird lintu = new Bird("Merilokki", "koko Suomi", "yleinen", category3);
			repository.save(lintu);
			
			Bird lintu2 = new Bird("Merihaikara", "Pohjois-Suomi", "harvinainen", category3);
			repository.save(lintu2);
			
			
			Finding finding1 = new Finding("4.11.2021", "Helsinki", 6, lintu);
			findingRepository.save(finding1);
			
			Finding finding2 = new Finding("5.11.2021", "Joensuu", 7, lintu2);
			findingRepository.save(finding2);
			
			for (Finding finding : findingRepository.findAll()) {
				log.info(finding.toString());
			}
			
			log.info("fetch all books");
			for (Bird bird : repository.findAll()) {
				log.info(bird.toString());
			}
			
			log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			
			User user1 = new User("user", 
					"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
					User user2 = new User("admin", 
					"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
					userRepository.save(user1);
				    userRepository.save(user2);

		};
	}

	}


