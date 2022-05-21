package actanalyzer.api.controller.retrieve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import actanalyzer.api.service.implementation.CategoryServiceInterface;
import actanalyzer.database.table.Category;

public class CategoryRetrieve {
	@Autowired
	private CategoryServiceInterface categoryService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/categories/")
	public ResponseEntity<Iterable<Category>> getCategories() {
		
		return new ResponseEntity<Iterable<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
	}
}
