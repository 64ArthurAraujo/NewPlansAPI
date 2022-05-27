package br.org.actanalyzer.api.repository;

import org.springframework.data.repository.CrudRepository;

import br.org.actanalyzer.database.table.UserCategory;

public interface UserCategoryRepository extends CrudRepository<UserCategory, Long> {

}
