package br.org.actanalyzer.api.request;

import br.org.actanalyzer.api.json.JsonRequest;
import br.org.actanalyzer.database.table.*;

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
