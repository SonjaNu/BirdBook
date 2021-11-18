package palvelinohjelmointi.BirdWatchingBook.domain;

import javax.persistence.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import palvelinohjelmointi.BirdWatchingBook.domain.Bird;



@Entity
public class Category {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
		private Long categoryId;
		private String name;
		
		//yhden suhde moneen liitos
		@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "category")
		@JsonIgnoreProperties("category")
		private List<Bird> birds;
		
		
public Category() {}


public Category(String name) {
	super();
	this.name = name;
}


public Long getCategoryId() {
	return categoryId;
}


public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}

public List<Bird> getBirds() {
	return birds;
}

public void setBirds(List<Bird> birds) {
	this.birds = birds;
}


@Override
public String toString() {
	return "Category [id=" + categoryId + ", name=" + name + "]";
}
}
