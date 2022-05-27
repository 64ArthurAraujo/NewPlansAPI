package actanalyzer.api.repository;

import org.springframework.data.repository.CrudRepository;

import actanalyzer.database.table.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
	
}
