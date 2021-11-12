package palvelinohjelmointi.BirdWatchingBook.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> deleteByCategoryId(Long categoryId); //yritys tehdä categoryn poisto niin, että koko lintu ei poistu, mutta ei toiminut

	 List<Category> findByName(String name);
}