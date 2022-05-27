package br.org.actanalyzer.api.service.implementation;

import br.org.actanalyzer.database.table.Category;

public interface CategoryServiceInterface extends ServiceInterface<Category, Category> {
	Iterable<Category> getAllCategories();
	Category getByName(String name);
}
