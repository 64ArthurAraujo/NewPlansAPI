package actanalyzer.api.service.implementation;

import actanalyzer.database.table.UserCategory;

public interface UserCategoryServiceInterface extends ServiceInterface<UserCategory> {
	Iterable<UserCategory> listUserCategories(Long userId);
}
