package org.actanalyzer.api.controller.insert;

import static org.actanalyzer.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.actanalyzer.api.request.*;
import org.actanalyzer.api.response.*;
import org.actanalyzer.api.service.implementation.*;
import org.actanalyzer.database.table.*;
import org.actanalyzer.database.table.util.ConvertedUserCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class UserInsert {
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private UserCategoryServiceInterface userCategoryService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/users/", consumes = "application/json")
	public ResponseEntity<UserJsonResponse> insertUser(@RequestBody UserJsonRequest jsonRequest) {
		User newCreatedUser = userService.insert(jsonRequest.convertJsonToEntity());
		
		return new ResponseEntity<>(new UserJsonResponse(newCreatedUser), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/users/categories/", consumes = "application/json") 
	public ResponseEntity<UserCategoryJsonResponse> createUser(@RequestBody UserCategoryJsonRequest jsonRequest) {
		ConvertedUserCategory newUserCategoryRelation = userCategoryService.insert(jsonRequest.convertJsonToEntity());	
		
		return new ResponseEntity<>(new UserCategoryJsonResponse(newUserCategoryRelation), HttpStatus.CREATED);
	}
}
