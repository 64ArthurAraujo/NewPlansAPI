package actanalyzer.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actanalyzer.api.repository.CategoryRepository;
import actanalyzer.api.service.implementation.CategoryServiceInterface;
import actanalyzer.database.table.Category;

@Service
public class CategoryService implements CategoryServiceInterface {
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public Category getById(Category entity) {
		for (Category categoryEntry : repository.findAll()) {
			if (categoryEntry.getId() == entity.getId()) {
				return categoryEntry;
			}
		}
		
		return null;
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
