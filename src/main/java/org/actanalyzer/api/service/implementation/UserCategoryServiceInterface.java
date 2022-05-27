package org.actanalyzer.api.service.implementation;

import org.actanalyzer.database.table.UserCategory;
import org.actanalyzer.database.table.util.CategorisedUserCategory;
import org.actanalyzer.database.table.util.ConvertedUserCategory;

public interface UserCategoryServiceInterface extends ServiceInterface<UserCategory, ConvertedUserCategory> {
	Iterable<UserCategory> listUserCategories(Long userId);
	CategorisedUserCategory convertToCategorisedUserCategory(UserCategory userCategory);
}
