package actanalyzer.api.controller;

import static actanalyzer.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import actanalyzer.api.service.implementation.CategoryServiceInterface;
import actanalyzer.api.service.implementation.GroupServiceInterface;
import actanalyzer.api.service.implementation.UserServiceInterface;
import actanalyzer.database.table.Category;
import actanalyzer.database.table.Group;
import actanalyzer.database.table.User;

@RestController
@RequestMapping(path = REQUEST_PATH_RETRIEVE)
public class Retrieve {
	
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private GroupServiceInterface groupService;
	
	@Autowired
	private CategoryServiceInterface categoryService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/")
	public ResponseEntity<Iterable<User>> getUsers() {
		
		return new ResponseEntity<Iterable<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/groups/")
	public ResponseEntity<Iterable<Group>> getGroups() {
		
		return new ResponseEntity<Iterable<Group>>(groupService.getAllGroups(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/categories/")
	public ResponseEntity<Iterable<Category>> getCategories() {
		
		return new ResponseEntity<Iterable<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
	}

}
