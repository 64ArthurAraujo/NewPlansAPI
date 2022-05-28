package org.actanalyzer.api.service;

import org.actanalyzer.api.repository.UserRepository;
import org.actanalyzer.api.service.implementation.UserServiceInterface;
import org.actanalyzer.database.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public User getById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public User getByToken(String authToken) {
		return repository.findByAuthToken(authToken);
	}

	@Override
	public User insert(User entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

}
