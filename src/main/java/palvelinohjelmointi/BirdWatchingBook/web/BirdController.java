package palvelinohjelmointi.BirdWatchingBook.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.BirdWatchingBook.domain.Bird;
import palvelinohjelmointi.BirdWatchingBook.domain.BirdRepository;
import palvelinohjelmointi.BirdWatchingBook.domain.CategoryRepository;
//endpoint    http://localhost:8080/

@Controller
public class BirdController {
	
	@Autowired
	private BirdRepository repository; //privaatti BirdRepository nimeltään repository
	
	@Autowired
	private CategoryRepository categoryRepository; 

	//Näytä kaikki linnut
	@RequestMapping(value = "/birdlist", method = RequestMethod.GET)
		public String birdList(Model model) {
		model.addAttribute("birds", repository.findAll()); 
		return "birdList";
	
	}
	//RESTful service --> hakee kaikki linnut, muuttaa javasta JSON:iksi
	@RequestMapping(value="/birds", method = RequestMethod.GET)
    public @ResponseBody List<Bird> birdListRest() {	
        return (List<Bird>) repository.findAll();
    }  
	
	//RESTful service --> hakee yhden linnun id:n mukaan, muuttaa javasta JSON:iksi
	 @RequestMapping(value="/birds/{id}", method = RequestMethod.GET) 
	    public @ResponseBody Optional<Bird> findBirdRest(@PathVariable("id") Long birdId) {	
	    	return repository.findById(birdId);
	    }    
	
	
	
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(@ModelAttribute Bird bird){
	        repository.save(bird);
	        return "redirect:/birdlist";  //uudelleen ohjataan toiseen endpointtiin
	    } 
	
	 @RequestMapping(value = "/add")
	    public String addBird(Model model){
	    	model.addAttribute("bird", new Bird());
	    	model.addAttribute("categories", categoryRepository.findAll());
	        return "addBird"; //palauttaa tyhjän lintulomakkeen
	    }   
	 
	
	 
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	 public String editBird(@PathVariable("id") long birdId, Model model) {
	     model.addAttribute("bird", repository.findById(birdId).get());
	     model.addAttribute("categories", categoryRepository.findAll());
	     return "editBird";
	     //jos linnun id on 0 tai null, se tekee sql insertin, muuten se tekee sql updaten
	 }	
	 
	
	 
	 @PreAuthorize(value = "hasAuthority('ADMIN')") //kuka saa suorittaa linnun poiston eli roolin on oltava Admin
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBird(@PathVariable("id") Long birdId, Model model) {
	    	repository.deleteById(birdId);
	        return "redirect:../birdlist";
	    }    
	 
	 @RequestMapping(value="/login")
		public String login() {
			return "login";
		}   
	 
	 
	 
	 
	 
}
