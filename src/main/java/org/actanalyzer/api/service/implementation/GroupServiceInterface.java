package org.actanalyzer.api.service.implementation;

import org.actanalyzer.database.table.Group;

public interface GroupServiceInterface extends ServiceInterface<Group, Group> {
	Iterable<Group> getAllGroups();
}
