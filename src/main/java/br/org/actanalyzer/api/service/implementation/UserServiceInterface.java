package br.org.actanalyzer.api.service.implementation;

import br.org.actanalyzer.database.table.User;

public interface UserServiceInterface extends ServiceInterface<User, User> {
	Iterable<User> getAllUsers();
	User findById(Long id);
	User getByToken(String authToken);
}



