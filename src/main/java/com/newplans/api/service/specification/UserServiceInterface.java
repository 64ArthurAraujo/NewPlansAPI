package com.newplans.api.service.specification;

import com.newplans.api.database.entity.User;
import com.newplans.api.exception.NoSuchEntryException;
import com.newplans.api.response.user.NoCredentialsResponse;

import java.util.List;

public interface UserServiceInterface extends ServiceInterface<User, User> {
	List<NoCredentialsResponse> getAllUsers();
	User getByToken(String token) throws NoSuchEntryException;
	NoCredentialsResponse getByIdWithoutCredentials(Long id) throws NoSuchEntryException;

	User getByEmail(String email) throws NoSuchEntryException;

	String login(User entity) throws Exception;
}



