package com.newplans.api.controller;

import com.newplans.api.configuration.Settings;
import com.newplans.api.database.entity.User;
import com.newplans.api.exception.NoSuchEntryException;
import com.newplans.api.exception.RequestValidationException;
import com.newplans.api.request.user.CreateRequest;
import com.newplans.api.request.user.LoginRequest;
import com.newplans.api.response.user.CreatedResponse;
import com.newplans.api.response.user.NoCredentialsResponse;
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
	public ResponseEntity create(@RequestBody CreateRequest request) {
		User createdUser;

		try {
			createdUser = service.insert(request.toEntity());
		} catch (RequestValidationException e) {
			return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
		}

		return new ResponseEntity<>(new CreatedResponse(createdUser), CREATED);
 	}

	 // READ
	 @RequestMapping(method = RequestMethod.POST, path = "/users/login", consumes = "application/json")
	 public ResponseEntity login(@RequestBody LoginRequest request) {
		 try {
			 return new ResponseEntity<>(service.login(request.toEntity()), OK);
		 } catch (Exception e) {
			 return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
		 }
	 }

	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
	public ResponseEntity<NoCredentialsResponse> getById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(service.getByIdWithoutCredentials(id), OK);
		} catch (NoSuchEntryException e) {
			return new ResponseEntity<>(NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public ResponseEntity<List<NoCredentialsResponse>> getAll() {
		return new ResponseEntity<>(service.getAllUsers(), OK);
	}

	// UPDATE
	public ResponseEntity updateName(@RequestBody LoginRequest request) {
		return null;
	}

	// DELETE
	public ResponseEntity delete(@RequestBody LoginRequest request) {
		return null;
	}
}
