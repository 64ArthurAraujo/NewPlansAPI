package br.org.actanalyzer.api.repository;

import org.springframework.data.repository.CrudRepository;

import br.org.actanalyzer.database.table.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
	
}
