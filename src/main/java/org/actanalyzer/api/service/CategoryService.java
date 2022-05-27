package org.actanalyzer.api.service;

import org.actanalyzer.api.repository.CategoryRepository;
import org.actanalyzer.api.service.implementation.CategoryServiceInterface;
import org.actanalyzer.database.table.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements CategoryServiceInterface {
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public Category getById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Category getByName(String name) {
		for (Category categoryEntry : repository.findAll()) {
			if (categoryEntry.getName().equals(name)) {
				return categoryEntry;
			}
		}
		
		return null;
	}

	@Override
	public Category insert(Category entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<Category> getAllCategories() {
		return repository.findAll();
	}
}
