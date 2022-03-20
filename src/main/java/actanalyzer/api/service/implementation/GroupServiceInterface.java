package actanalyzer.api.service.implementation;

import actanalyzer.database.table.Group;

public interface GroupServiceInterface extends ServiceInterface<Group> {
	Iterable<Group> getAllGroups();
}
