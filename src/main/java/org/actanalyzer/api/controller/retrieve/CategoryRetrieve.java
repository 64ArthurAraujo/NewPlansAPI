package org.actanalyzer.api.controller.retrieve;

import static org.actanalyzer.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

import org.actanalyzer.api.service.implementation.CategoryServiceInterface;
import org.actanalyzer.database.table.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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
