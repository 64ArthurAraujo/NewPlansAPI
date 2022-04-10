package actanalyzer.api.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import actanalyzer.api.json.JsonRequest;
import actanalyzer.api.service.implementation.CategoryServiceInterface;
import actanalyzer.api.service.implementation.UserServiceInterface;
import actanalyzer.database.table.*;

@Component
public class UserCategoryJsonRequest implements JsonRequest<UserCategory> {
	public String categoryName;
	public String userToken;
	
	@Autowired
	UserServiceInterface userService;

	@Autowired
	CategoryServiceInterface categoryService;
	
	@Override
	public UserCategory convertJsonToEntity() {
		UserCategory newUserCategoryRelation = new UserCategory();
		
		User userAcessing = userService.getByToken(this.userToken);
		Category categoryAcessed = categoryService.getByName(this.categoryName);
		
		newUserCategoryRelation.setIdUser(userAcessing.getId());
		newUserCategoryRelation.setIdCategory(categoryAcessed.getId());
		newUserCategoryRelation.setTimesSearched(1);
		
		return newUserCategoryRelation;
	}
	
}
