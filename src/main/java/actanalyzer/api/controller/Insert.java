package actanalyzer.api.controller;

import static actanalyzer.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import actanalyzer.api.request.CategoryJsonRequest;
import actanalyzer.api.request.GroupJsonRequest;
import actanalyzer.api.request.UserCategoryJsonRequest;
import actanalyzer.api.request.UserJsonRequest;
import actanalyzer.api.response.CategoryJsonResponse;
import actanalyzer.api.response.GroupJsonResponse;
import actanalyzer.api.response.UserCategoryJsonResponse;
import actanalyzer.api.response.UserJsonResponse;
import actanalyzer.api.service.implementation.CategoryServiceInterface;
import actanalyzer.api.service.implementation.GroupServiceInterface;
import actanalyzer.api.service.implementation.UserCategoryServiceInterface;
import actanalyzer.api.service.implementation.UserServiceInterface;
import actanalyzer.database.table.Category;
import actanalyzer.database.table.Group;
import actanalyzer.database.table.User;
import actanalyzer.database.table.UserCategory;

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
