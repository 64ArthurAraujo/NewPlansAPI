package actanalyzer.api.repository;

import org.springframework.data.repository.CrudRepository;

import actanalyzer.database.table.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
