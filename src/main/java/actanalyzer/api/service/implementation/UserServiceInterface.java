package actanalyzer.api.service.implementation;

import actanalyzer.database.table.User;

public interface UserServiceInterface extends ServiceInterface<User, User> {
	Iterable<User> getAllUsers();
	User getByToken(String authToken);
}



