package actanalyzer.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actanalyzer.api.repository.CategoryRepository;
import actanalyzer.api.repository.UserCategoryRepository;
import actanalyzer.api.repository.UserRepository;
import actanalyzer.api.service.implementation.UserCategoryServiceInterface;
import actanalyzer.database.table.Category;
import actanalyzer.database.table.Group;
import actanalyzer.database.table.User;
import actanalyzer.database.table.UserCategory;
import actanalyzer.database.table.util.CategorisedUserCategory;
import actanalyzer.database.table.util.ConvertedUserCategory;

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
		for (UserCategory userCategoryEntry : repository.findAll()) {
			if (userCategoryEntry.getId() == entity.getId()) {
				return userCategoryEntry;
			}
		}
		
		return null;
	}

	@Override
	public ConvertedUserCategory insert(UserCategory entity) {
		if (categoryIsAlreadyCreated(entity)) {
			Optional<UserCategory> optCategory = repository.findById(getAlreadyCreatedCategory(entity).getId());
			
			UserCategory existingUserCategoryRelation = optCategory.get();
			
			int timesSearched = existingUserCategoryRelation.getTimesSearched();
			
			entity.setId(existingUserCategoryRelation.getId());
			entity.setTimesSearched(timesSearched + 1);
			
			repository.save(entity);
			
			return convertUserCategory(entity);
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
	
	private UserCategory getAlreadyCreatedCategory(UserCategory entity) {
		ConvertedUserCategory convertedEntity = convertUserCategory(entity);
		
		for (UserCategory categoryEntry : repository.findAll()) {
			ConvertedUserCategory convertedEntry = convertUserCategory(categoryEntry);
			
			if (convertedEntry.getIdCategory() == convertedEntity.getIdCategory() && convertedEntry.getIdUser() == convertedEntity.getIdUser()) {
				return categoryEntry;
			}
		}
		
		return null;
	}

	private ConvertedUserCategory convertUserCategory(UserCategory userCategory) {
		Category category = categoryRepository.findByName(userCategory.getCategoryName());
		User user = userRepository.findByAuthToken(userCategory.getUserToken());
		
		ConvertedUserCategory converted = new ConvertedUserCategory();
		
		converted.setId(userCategory.getId());
		converted.setIdCategory(category.getId());
		converted.setIdUser(user.getId());
		converted.setTimesSearched(userCategory.getTimesSearched());
		
		return converted;
	}
	
	public CategorisedUserCategory convertToCategorisedUserCategory(UserCategory userCategory) {
		User user = userRepository.findByAuthToken(userCategory.getUserToken());
		
		CategorisedUserCategory converted = new CategorisedUserCategory();
		
		converted.setId(userCategory.getId());
		converted.setCategoryName(userCategory.getCategoryName());
		converted.setUserName(user.getUsername());
		converted.setTimesSearched(userCategory.getTimesSearched());
		
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
