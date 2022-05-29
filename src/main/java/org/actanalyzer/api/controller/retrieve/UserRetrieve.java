package org.actanalyzer.api.controller.retrieve;

import static org.actanalyzer.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.actanalyzer.api.service.implementation.UserCategoryServiceInterface;
import org.actanalyzer.api.service.implementation.UserServiceInterface;
import org.actanalyzer.database.table.User;
import org.actanalyzer.database.table.UserCategory;
import org.actanalyzer.database.table.util.CategorisedUserCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = REQUEST_PATH_RETRIEVE)
public class UserRetrieve {
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private UserCategoryServiceInterface userCategoryService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/")
	public ResponseEntity<Iterable<User>> getUsers() {
		
		return new ResponseEntity<Iterable<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") @NotNull Long id) {
		
		return new ResponseEntity<User>(userService.getById(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}/interest/total")
	public ResponseEntity<Integer> getUserTotalInterest(@PathVariable("id") @NotNull Long id) {
		int interestAmount = 0;
		
		for (UserCategory entry : userCategoryService.listUserCategories(id)) {
			interestAmount += entry.getInterestRate();
		}
		
		return new ResponseEntity<Integer>(interestAmount, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}/interest/categorised")
	public ResponseEntity<List<CategorisedUserCategory>> getCategorisedInterests(@PathVariable("id") @NotNull Long id) {
		List<CategorisedUserCategory> interestCategories = new ArrayList<>();
		
		for (UserCategory entry : userCategoryService.listUserCategories(id)) {
			interestCategories.add(userCategoryService.convertToCategorisedUserCategory(entry));
		}
		
		return new ResponseEntity<List<CategorisedUserCategory>>(interestCategories, HttpStatus.OK);
	}
}
