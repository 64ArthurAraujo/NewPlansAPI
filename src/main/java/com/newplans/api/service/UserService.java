package com.newplans.api.service;

import com.newplans.api.database.entity.User;
import com.newplans.api.exception.IncorrectCredentialsException;
import com.newplans.api.exception.NoSuchEntryException;
import com.newplans.api.repository.UserRepository;
import com.newplans.api.response.user.NoCredentialsResponse;
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

		if (!user.isPresent()) {
			throw new NoSuchEntryException("No entry found with id: '" + id + "'");
		}

		return user.get();
	}

	public NoCredentialsResponse getByIdWithoutCredentials(Long id) throws NoSuchEntryException {
		return new NoCredentialsResponse(this.getById(id));
	}

	@Override
	public User getByEmail(String email) throws NoSuchEntryException {
		Optional<User> user = repository.findByEmail(email);

		if (!user.isPresent()) {
			throw new NoSuchEntryException("No entry found with email: '" + email + "'");
		}

		return user.get();
	}

	@Override
	public User getByToken(String token) throws NoSuchEntryException {
		Optional<User> user = repository.findByToken(token);

		if (!user.isPresent()) {
			throw new NoSuchEntryException("No entry found with token: '" + token + "'");
		}

		return user.get();
	}

	@Override
	public User insert(User entity) {
		String hashedPasswd = new HashedPassword(entity.getEmail(), entity.getPassword()).getValue();

		entity.setPassword(hashedPasswd);
		entity.setToken(new Token(20).getValue());

		return repository.save(entity);
	}

	public String login(User entity) throws NoSuchEntryException, IncorrectCredentialsException {
		String hashedPasswd = new HashedPassword(entity.getEmail(), entity.getPassword()).getValue();
		User userToCompareHash = this.getByEmail(entity.getEmail());

		if (!userToCompareHash.getPassword().equals(hashedPasswd)) {
			throw new IncorrectCredentialsException("Credentials did not match");
		}

		return userToCompareHash.getToken();
	}


	@Override
	public List<NoCredentialsResponse> getAllUsers() {
		List<NoCredentialsResponse> usersFiltered = new ArrayList<>();

		for (User entry : repository.findAll()) {
			usersFiltered.add(new NoCredentialsResponse(entry));
		}

		return usersFiltered;
	}

}
