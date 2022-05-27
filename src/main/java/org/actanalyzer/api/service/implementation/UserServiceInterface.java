package org.actanalyzer.api.service.implementation;

import org.actanalyzer.database.table.User;

public interface UserServiceInterface extends ServiceInterface<User, User> {
	Iterable<User> getAllUsers();
	User getByToken(String authToken);
}



