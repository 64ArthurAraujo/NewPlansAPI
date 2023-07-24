package com.newplans.api.controller;

import com.newplans.api.configuration.Settings;
import com.newplans.api.database.entity.User;
import com.newplans.api.exception.RequestValidationException;
import com.newplans.api.request.UserCreateRequest;
import com.newplans.api.response.UserCreatedResponse;
import com.newplans.api.response.UserResponse;
import com.newplans.api.service.implementation.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = Settings.REQUEST_PATH)
public class UserController {
	@Autowired
	private UserServiceInterface service;
	
	@RequestMapping(method = RequestMethod.POST, path = "/users/", consumes = "application/json")
	public ResponseEntity<UserCreatedResponse> insertUser(@RequestBody UserCreateRequest request) throws RequestValidationException {
		User newCreatedUser = service.insert(request.toEntity());
		
		return new ResponseEntity<>(new UserCreatedResponse(newCreatedUser), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/users/")
	public ResponseEntity<List<UserResponse>> getUsers() {
		return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
	}
}
