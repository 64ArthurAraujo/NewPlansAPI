package com.newplans.api.service.implementation;

import com.newplans.api.database.entity.User;
import com.newplans.api.response.UserResponse;

import java.util.List;

public interface UserServiceInterface extends ServiceInterface<User, User> {
	List<UserResponse> getAllUsers();
	User getByToken(String token);
	UserResponse getByIdWithoutCredentials(Long id);
}



