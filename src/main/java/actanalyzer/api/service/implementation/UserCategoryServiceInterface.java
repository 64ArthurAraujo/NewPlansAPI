package actanalyzer.api.service.implementation;

import actanalyzer.database.table.ConvertedUserCategory;
import actanalyzer.database.table.UserCategory;

public interface UserCategoryServiceInterface extends ServiceInterface<UserCategory, ConvertedUserCategory> {
	Iterable<UserCategory> listUserCategories(Long userId);
}
