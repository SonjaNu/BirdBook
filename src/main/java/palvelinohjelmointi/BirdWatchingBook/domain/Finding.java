package palvelinohjelmointi.BirdWatchingBook.domain;

import javax.persistence.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import palvelinohjelmointi.BirdWatchingBook.domain.Bird;


	@Entity
	public class Finding {
		 @Id
		 @GeneratedValue(strategy=GenerationType.AUTO)
			private Long findingId;
			private String place;
			private String date;
			private int count;
	

			@ManyToOne  
			    //many on Bird-luokka ja One on Category (private Category category;) (One on lähin alla oleva attribuutti)
			 @JsonIgnoreProperties ("finding")    
			 @JoinColumn(name = "id") //viiteavaimena linnun id 
			 	private Bird bird; // tämä on addFinding -templatessa th:field="*{bird}"
			
			
	public Finding() {}


public Finding(String place, String date, int count, Bird bird) {  
		super();
		
		this.place = place;
		this.date = date;
		this.count = count;
		this.bird = bird;
		
	}


	public Long getFindingId() {
		return findingId;
	}


	public void setFindingId(Long findingId) {
		this.findingId = findingId;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	

	public Bird getBird() {
		return bird;
	}


	public void setBird(Bird bird) {
		this.bird = bird;
	}


	@Override
	public String toString() {
		return "Finding [findingId=" + findingId + ", place=" + place + ", date=" + date + ", count=" + count
				+ "]";
	}
	
	
	
	

}
