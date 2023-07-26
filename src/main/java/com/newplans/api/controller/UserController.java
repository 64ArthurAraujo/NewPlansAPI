package com.newplans.api.controller;

import com.newplans.api.configuration.Settings;
import com.newplans.api.database.entity.User;
import com.newplans.api.exception.NoSuchEntryException;
import com.newplans.api.exception.RequestValidationException;
import com.newplans.api.request.user.UserCreateRequest;
import com.newplans.api.request.user.UserLoginRequest;
import com.newplans.api.response.UserCreatedResponse;
import com.newplans.api.response.UserResponse;
import com.newplans.api.service.specification.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = Settings.REQUEST_PATH)
public class UserController {
	@Autowired
	private UserServiceInterface service;

	// CREATE
	
	@RequestMapping(method = RequestMethod.POST, path = "/users", consumes = "application/json")
	public ResponseEntity insert(@RequestBody UserCreateRequest request) {
		try {
			User newCreatedUser = service.insert(request.toEntity());

			return new ResponseEntity<>(new UserCreatedResponse(newCreatedUser), CREATED);
		} catch (RequestValidationException e) {
			return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
		}
 	}

	 // READ
	 @RequestMapping(method = RequestMethod.POST, path = "/users/login", consumes = "application/json")
	 public ResponseEntity login(@RequestBody UserLoginRequest request) {
		 try {
			 String token = service.login(request.toEntity());
			 return new ResponseEntity<>(token, OK);
		 } catch (Exception e) {
			 return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
		 }
	 }

	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
	public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(service.getByIdWithoutCredentials(id), OK);
		} catch (NoSuchEntryException e) {
			return new ResponseEntity<>(NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public ResponseEntity<List<UserResponse>> getAll() {
		return new ResponseEntity<>(service.getAllUsers(), OK);
	}

	// UPDATE
	public ResponseEntity updateName(@RequestBody UserLoginRequest request) {
		return null;
	}

	// DELETE
	public ResponseEntity delete(@RequestBody UserLoginRequest request) {
		return null;
	}
}
