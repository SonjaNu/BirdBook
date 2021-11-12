package palvelinohjelmointi.BirdWatchingBook.domain;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import palvelinohjelmointi.BirdWatchingBook.domain.Category;
import palvelinohjelmointi.BirdWatchingBook.domain.Finding;

@Entity
public class Bird {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String distribution;
	private String rarity;
	

	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "bird")
		@JsonIgnoreProperties("bird")
		private List<Finding> finding;
	
	 @ManyToOne  //yhteystyyppi kahden tietokantataulun välillä
	    //many on Bird-luokka ja One on Category (private Category category;) (One on lähin alla oleva attribuutti)
	 @JsonIgnoreProperties ("bird")    
	 @JoinColumn(name = "categoryId") //FK, viiteavain-attribuutin (viiteavainsarakkeen) nimi on categoryId
	    private Category category;
	 
	 public Bird() {}
	
	public Bird(String name, String distribution, String rarity, Category category) {
		super();
		this.name = name;
		this.distribution = distribution;
		this.rarity = rarity;
		this.category = category;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistribution() {
		return distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Finding> getFinding() {
		return finding;
	}

	public void setFinding(List<Finding> finding) {
		this.finding = finding;
	}
	

	@Override
	public String toString() {
		
		if (this.category != null) {
		return "Bird [id=" + id + ", name=" + name + ", distribution=" + distribution + ", rarity=" + rarity + ", category =" + this.getCategory() + "]";
		}else {
			return "Bird [id=" + id + ", name=" + name + ", distribution=" + distribution + ", rarity=" + rarity + "]";
		
	}
	}

	
	}


