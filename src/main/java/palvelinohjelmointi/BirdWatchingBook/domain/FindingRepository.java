package palvelinohjelmointi.BirdWatchingBook.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FindingRepository extends CrudRepository<Finding, Long> {
	
	List<Finding> findByBird(Bird bird); //tämä komento luotu havaintojen näyttämistä varten FindingControllerissa metodissa  public String viewFindings

	 List<Finding> findByPlace(String place);
}