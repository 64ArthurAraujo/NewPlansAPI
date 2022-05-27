package actanalyzer.api.service.implementation;

import actanalyzer.database.table.UserCategory;
import actanalyzer.database.table.util.CategorisedUserCategory;
import actanalyzer.database.table.util.ConvertedUserCategory;

public interface UserCategoryServiceInterface extends ServiceInterface<UserCategory, ConvertedUserCategory> {
	Iterable<UserCategory> listUserCategories(Long userId);
	CategorisedUserCategory convertToCategorisedUserCategory(UserCategory userCategory);
}
