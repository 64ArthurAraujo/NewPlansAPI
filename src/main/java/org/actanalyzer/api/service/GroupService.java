package org.actanalyzer.api.service;

import org.actanalyzer.api.repository.GroupRepository;
import org.actanalyzer.api.service.implementation.GroupServiceInterface;
import org.actanalyzer.database.table.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService implements GroupServiceInterface  {
	
	@Autowired
	private GroupRepository repository;
	
	public GroupService(GroupRepository repository) {
		this.repository = repository;
	}

	@Override
	public Group getById(Long id) {
		return repository.findById(id).get();
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
