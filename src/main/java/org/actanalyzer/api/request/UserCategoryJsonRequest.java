package org.actanalyzer.api.request;

import org.actanalyzer.api.json.JsonRequest;
import org.actanalyzer.database.table.*;

public class UserCategoryJsonRequest implements JsonRequest<UserCategory> {
	public String categoryName;
	public String userToken;
	
	@Override
	public UserCategory convertJsonToEntity() {
		UserCategory newUserCategoryRelation = new UserCategory();
		
		newUserCategoryRelation.setCategoryName(categoryName);
		newUserCategoryRelation.setUserToken(userToken);
		newUserCategoryRelation.setInterestRate(1);
		
		return newUserCategoryRelation;
	}
}
