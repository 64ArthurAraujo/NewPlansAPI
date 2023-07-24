package com.newplans.api.service;

import com.newplans.api.database.entity.User;
import com.newplans.api.repository.UserRepository;
import com.newplans.api.security.HashedPassword;
import com.newplans.api.security.Token;
import com.newplans.api.service.implementation.UserServiceInterface;
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
	public User getByToken(String token) {
		return repository.findByToken(token);
	}

	@Override
	public User insert(User entity) {
		String hashedPasswd = new HashedPassword(entity.getEmail(), entity.getPassword()).getValue();

		entity.setPassword(hashedPasswd);
		entity.setToken(new Token(20).getValue());

		return repository.save(entity);
	}

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

}