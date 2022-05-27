package br.org.actanalyzer.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.actanalyzer.api.repository.GroupRepository;
import br.org.actanalyzer.api.service.implementation.GroupServiceInterface;
import br.org.actanalyzer.database.table.Group;

@Service
public class GroupService implements GroupServiceInterface {
	
	@Autowired
	private GroupRepository repository;
	
	public GroupService(GroupRepository repository) {
		this.repository = repository;
	}

	@Override
	public Group getById(Group entity) {
		for (Group groupEntry : repository.findAll()) {
			if (groupEntry.getId() == entity.getId()) {
				return groupEntry;
			}
		}
		
		return null;
	}

	@Override
	public Group insert(Group entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<Group> getAllGroups() {
		return repository.findAll();
	}
}
