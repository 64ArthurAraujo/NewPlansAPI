package org.actanalyzer.api.service.implementation;

import org.actanalyzer.database.table.Category;

public interface CategoryServiceInterface extends ServiceInterface<Category, Category> {
	Iterable<Category> getAllCategories();
	Category getByName(String name);
}
