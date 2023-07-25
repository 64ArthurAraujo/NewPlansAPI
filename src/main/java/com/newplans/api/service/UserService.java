package com.newplans.api.service;

import com.newplans.api.database.entity.User;
import com.newplans.api.exception.NoSuchEntryException;
import com.newplans.api.repository.UserRepository;
import com.newplans.api.response.UserResponse;
import com.newplans.api.security.HashedPassword;
import com.newplans.api.security.Token;
import com.newplans.api.service.specification.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public User getById(Long id) throws NoSuchEntryException {
		Optional<User> user = repository.findById(id);

		if (user.isPresent()) {
			return user.get();
		}

		throw new NoSuchEntryException("No entry found with id: '" + id + "'");
	}

	public UserResponse getByIdWithoutCredentials(Long id) throws NoSuchEntryException {
		return new UserResponse(this.getById(id));
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
	public List<UserResponse> getAllUsers() {
		List<UserResponse> usersNoCredentials = new ArrayList<>();

		for (User entry : repository.findAll()) {
			usersNoCredentials.add(new UserResponse(entry));
		}

		return usersNoCredentials;
	}

}
