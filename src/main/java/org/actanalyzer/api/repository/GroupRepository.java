package org.actanalyzer.api.repository;

import org.actanalyzer.database.table.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
	
}
