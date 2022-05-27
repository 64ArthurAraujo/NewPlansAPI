package org.actanalyzer.api.repository;

import org.actanalyzer.database.table.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findByName(String name);
}
