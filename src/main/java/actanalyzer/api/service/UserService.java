package actanalyzer.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actanalyzer.api.repository.UserRepository;
import actanalyzer.api.service.implementation.UserServiceInterface;
import actanalyzer.database.table.User;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public User getById(User entity) {
		return findById(entity.getId());
	}
	
	@Override
	public User findById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public User getByToken(String authToken) {
		for (User userEntry : repository.findAll()) {
			if (userEntry.getAuthToken().equals(authToken)) {
				return userEntry;
			}
		}
		
		return null;
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
