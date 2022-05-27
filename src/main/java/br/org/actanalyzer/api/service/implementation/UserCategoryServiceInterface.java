package br.org.actanalyzer.api.service.implementation;

import br.org.actanalyzer.database.table.UserCategory;
import br.org.actanalyzer.database.table.util.CategorisedUserCategory;
import br.org.actanalyzer.database.table.util.ConvertedUserCategory;

public interface UserCategoryServiceInterface extends ServiceInterface<UserCategory, ConvertedUserCategory> {
	Iterable<UserCategory> listUserCategories(Long userId);
	CategorisedUserCategory convertToCategorisedUserCategory(UserCategory userCategory);
}
