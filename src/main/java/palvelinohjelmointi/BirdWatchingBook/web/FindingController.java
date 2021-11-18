package palvelinohjelmointi.BirdWatchingBook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.BirdWatchingBook.domain.Bird;
import palvelinohjelmointi.BirdWatchingBook.domain.BirdRepository;
import palvelinohjelmointi.BirdWatchingBook.domain.Finding;
import palvelinohjelmointi.BirdWatchingBook.domain.FindingRepository;


@Controller
public class FindingController {
	
	
	@Autowired
	private FindingRepository findingRepository;
	
	@Autowired
	private BirdRepository repository; //privaatti BirdRepository nimeltään repository
	
	@RequestMapping(value = "/findinglist/{id}", method = RequestMethod.GET)
	
	 public String viewFindings(@PathVariable("id") long birdId, Model model) {		
		Bird bird = new Bird();  //luodaan uusi lintu-olio
		bird.setId(birdId);		//ja asetataan siihen linnun id (birdId)
		model.addAttribute("findings", findingRepository.findByBird(bird));  //haetaan findingRepositorysta komennolla findByBird(bird), jossa parametriin on nyt asetettu linnun id
		//findingRepositoryssä luotiin erikseen komento List<Finding> findByBird(Bird bird);
	     return "findingsByBird";
	 }
	

	 @RequestMapping(value = "/savefinding", method = RequestMethod.POST)
	    public String saveFinding( @ModelAttribute Finding finding){	
		 findingRepository.save(finding);
	        return "redirect:/birdlist";  
	    } 
	
	 @RequestMapping(value = "/addfinding")
	    public String addFinding(Model model){
	    	model.addAttribute("finding", new Finding());
	    	model.addAttribute("birds", repository.findAll());
	        return "addFinding";
	    }   
	 
	 @PreAuthorize(value = "hasAuthority('ADMIN')") // roolin on oltava Admin
	 @RequestMapping(value = "/editfinding/{id}", method = RequestMethod.GET)
	 public String editFinding(@PathVariable("id") long findingId, Model model) {
	     model.addAttribute("finding", findingRepository.findById(findingId).get());
	     return "editFinding";
	   //jos havainnon id on 0 tai null, se tekee sql insertin, muuten se tekee sql updaten
		 
	 }	
	 
	 
	 @PreAuthorize(value = "hasAuthority('ADMIN')") // roolin on oltava Admin
	 @RequestMapping(value = "/deletefinding/{id}", method = RequestMethod.GET)
	    public String deleteFinding(@PathVariable("id") Long findingId, Model model) {
	    	findingRepository.deleteById(findingId);
	        return "redirect:../findingsByBird";
	    } 
}

