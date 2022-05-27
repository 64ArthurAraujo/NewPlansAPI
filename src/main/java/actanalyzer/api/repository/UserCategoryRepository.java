package actanalyzer.api.repository;

import org.springframework.data.repository.CrudRepository;

import actanalyzer.database.table.UserCategory;

public interface UserCategoryRepository extends CrudRepository<UserCategory, Long> {

}
