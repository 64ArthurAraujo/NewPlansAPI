package br.org.actanalyzer.api.service.implementation;

import br.org.actanalyzer.database.table.Group;

public interface GroupServiceInterface extends ServiceInterface<Group, Group> {
	Iterable<Group> getAllGroups();
}
