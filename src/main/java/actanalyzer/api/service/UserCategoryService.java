package actanalyzer.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actanalyzer.api.repository.*;
import actanalyzer.api.service.implementation.UserCategoryServiceInterface;
import actanalyzer.database.table.*;

@Service
public class UserCategoryService implements UserCategoryServiceInterface {
	
	@Autowired
	private UserCategoryRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserCategory getById(UserCategory entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConvertedUserCategory insert(UserCategory entity) {
		if (categoryIsAlreadyCreated(entity)) {
			UserCategory existingCategory = entity;
			
			int timesSearched = existingCategory.getTimesSearched();
			
			existingCategory.setTimesSearched(timesSearched ++);
			
			return convertUserCategory(repository.save(existingCategory));
		} else {
			return convertUserCategory(repository.save(entity));
		}
	}

	private boolean categoryIsAlreadyCreated(UserCategory entity) {
		ConvertedUserCategory convertedEntity = convertUserCategory(entity);
		
		for (UserCategory categoryEntry : repository.findAll()) {
			ConvertedUserCategory convertedEntry = convertUserCategory(categoryEntry);
			
			if (convertedEntry.getIdCategory() == convertedEntity.getIdCategory() && convertedEntry.getIdUser() == convertedEntity.getIdUser()) {
				return true;
			}
		}
		
		return false;
	}

	private ConvertedUserCategory convertUserCategory(UserCategory userCategory) {
		Category category = categoryRepository.findByName(userCategory.getCategoryName());
		User user = userRepository.findByAuthToken(userCategory.getUserToken());
		
		ConvertedUserCategory converted = new ConvertedUserCategory();
		
		converted.setId(userCategory.getId());
		converted.setIdCategory(category.getId());
		converted.setIdUser(user.getId());
		
		return converted;
	}

	@Override
	public Iterable<UserCategory> listUserCategories(Long userId) {
		List<UserCategory> categoriesFromUser = new ArrayList<UserCategory>();
		
		for (UserCategory categoryEntry : repository.findAll()) {
			ConvertedUserCategory convertedCategoryEntry = convertUserCategory(categoryEntry);
			
			if (convertedCategoryEntry.getIdUser() == userId) {
				categoriesFromUser.add(categoryEntry);
			}
		}
		
		return categoriesFromUser;
	}
}
