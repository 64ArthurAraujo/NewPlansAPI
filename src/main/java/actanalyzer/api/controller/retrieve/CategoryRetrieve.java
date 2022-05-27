package actanalyzer.api.controller.retrieve;

import static actanalyzer.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import actanalyzer.api.service.implementation.CategoryServiceInterface;
import actanalyzer.database.table.Category;

@RestController
@RequestMapping(path = REQUEST_PATH_RETRIEVE)
public class CategoryRetrieve {
	@Autowired
	private CategoryServiceInterface categoryService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/categories/")
	public ResponseEntity<Iterable<Category>> getCategories() {
		
		return new ResponseEntity<Iterable<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
	}
}
