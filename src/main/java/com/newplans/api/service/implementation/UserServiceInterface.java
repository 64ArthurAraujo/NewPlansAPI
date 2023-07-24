package com.newplans.api.service.implementation;

import com.newplans.api.database.entity.User;

public interface UserServiceInterface extends ServiceInterface<User, User> {
	Iterable<User> getAllUsers();
	User getByToken(String token);
}



