package actanalyzer.api.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actanalyzer.api.repository.UserCategoryRepository;
import actanalyzer.api.service.implementation.UserCategoryServiceInterface;
import actanalyzer.database.table.UserCategory;

@Service
public class UserCategoryService implements UserCategoryServiceInterface {
	
	@Autowired
	private UserCategoryRepository repository;
	
	@Override
	public UserCategory getById(UserCategory entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserCategory insert(UserCategory entity) {
		if (categoryIsAlreadyCreated(entity)) {
			UserCategory existingCategory = getCategory(entity.getIdCategory());
			
			int timesSearched = existingCategory.getTimesSearched();
			
			existingCategory.setTimesSearched(timesSearched ++);
			
			return repository.save(existingCategory);
		} else {
			return repository.save(entity);
		}
	}

	private boolean categoryIsAlreadyCreated(UserCategory entity) {
		for (UserCategory categoryEntry : repository.findAll()) {
			if (categoryEntry.getIdCategory() == entity.getIdCategory() && categoryEntry.getIdUser() == entity.getIdUser()) {
				return true;
			}
		}
		
		return false;
	}
	
	private UserCategory getCategory(Long idCategory) {
		Optional<UserCategory> retrievedCategory = repository.findById(idCategory);
		
		return retrievedCategory.get();
	}

	@Override
	public Iterable<UserCategory> listUserCategories(Long userId) {
		List<UserCategory> categoriesFromUser = new ArrayList<UserCategory>();
		
		for (UserCategory categoryEntry : repository.findAll()) {
			if (categoryEntry.getIdUser() == userId) {
				categoriesFromUser.add(categoryEntry);
			}
		}
		
		return categoriesFromUser;
	}
}
