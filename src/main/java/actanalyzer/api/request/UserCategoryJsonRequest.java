package actanalyzer.api.request;

import actanalyzer.api.json.JsonRequest;
import actanalyzer.database.table.*;

public class UserCategoryJsonRequest implements JsonRequest<UserCategory> {
	public String categoryName;
	public String userToken;
	
	@Override
	public UserCategory convertJsonToEntity() {
		UserCategory newUserCategoryRelation = new UserCategory();
		
		newUserCategoryRelation.setCategoryName(categoryName);
		newUserCategoryRelation.setUserToken(userToken);
		newUserCategoryRelation.setTimesSearched(1);
		
		return newUserCategoryRelation;
	}
}
