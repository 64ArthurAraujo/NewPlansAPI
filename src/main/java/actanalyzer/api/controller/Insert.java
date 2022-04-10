package actanalyzer.api.controller;

import static actanalyzer.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import actanalyzer.api.request.*;
import actanalyzer.api.response.*;
import actanalyzer.api.service.implementation.*;

import actanalyzer.database.table.*;


@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class Insert {
	
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private GroupServiceInterface groupService;
	
	@Autowired
	private CategoryServiceInterface categoryService;
	
	@Autowired
	private UserCategoryServiceInterface userCategoryService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/users/", consumes = "application/json")
	public ResponseEntity<UserJsonResponse> insertUser(@RequestBody UserJsonRequest jsonRequest) {
		User newCreatedUser = userService.insert(jsonRequest.convertJsonToEntity());
		
		return new ResponseEntity<>(new UserJsonResponse(newCreatedUser), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/groups/", consumes = "application/json")
	public ResponseEntity<GroupJsonResponse> createGroup(@RequestBody GroupJsonRequest jsonRequest) {
		Group newCreatedGroup = groupService.insert(jsonRequest.convertJsonToEntity());
		
		return new ResponseEntity<>(new GroupJsonResponse(newCreatedGroup), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/categories/", consumes = "application/json")
	public ResponseEntity<CategoryJsonResponse> createCategory(@RequestBody CategoryJsonRequest jsonRequest) {
		Category newCreatedCategory = categoryService.insert(jsonRequest.convertJsonToEntity());
		
		return new ResponseEntity<>(new CategoryJsonResponse(newCreatedCategory), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/users/categories/", consumes = "application/json") 
	public ResponseEntity<UserCategoryJsonResponse> createUser(@RequestBody UserCategoryJsonRequest jsonRequest) {
		UserCategory newUserCategoryRelation = userCategoryService.insert(jsonRequest.convertJsonToEntity());	
		
		return new ResponseEntity<>(new UserCategoryJsonResponse(newUserCategoryRelation), HttpStatus.CREATED);
	}
}
