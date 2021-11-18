package palvelinohjelmointi.BirdWatchingBook.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.BirdWatchingBook.domain.Category;
import palvelinohjelmointi.BirdWatchingBook.domain.CategoryRepository;


@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String categoryList(Model model) {
		model.addAttribute("categories", categoryRepository.findAll()); 
		return "categoryList";

	}
	

	 @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	    public String save(@ModelAttribute Category category){
	        categoryRepository.save(category);
	        return "redirect:/categorylist";  //uudelleen ohjataan toiseen endpointtiin
	    } 
	
	 @RequestMapping(value = "/addcategory")
	    public String addCategory(Model model){
	    	model.addAttribute("category", new Category());
	        return "addCategory";
	    }  
	 
	 @RequestMapping(value = "/editcategory/{id}", method = RequestMethod.GET)
	 public String editBird(@PathVariable("id") long categoryId, Model model) {
	     model.addAttribute("category", categoryRepository.findById(categoryId).get());
	   //  model.addAttribute("categories", categoryRepository.findAll());
	     return "editCategory";
	 }	
	 
	 @PreAuthorize(value = "hasAuthority('ADMIN')") //kuka saa suorittaa categoryn poiston eli roolin on oltava Admin
	 @RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
	    public String deleteCategory(@PathVariable("id") Long categoryId, Model model) {
	    	categoryRepository.deleteById(categoryId);
	    	
	    	return "redirect:../categorylist";
	    } 
}
