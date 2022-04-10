package actanalyzer.api.controller;

import static actanalyzer.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import actanalyzer.api.service.implementation.*;

import actanalyzer.database.table.*;

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
