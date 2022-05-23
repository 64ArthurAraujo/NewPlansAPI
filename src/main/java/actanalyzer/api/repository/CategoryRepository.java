package actanalyzer.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import actanalyzer.database.table.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findByName(String name);
}
