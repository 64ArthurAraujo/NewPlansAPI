package br.org.actanalyzer.api.request;

import br.org.actanalyzer.api.json.JsonRequest;
import br.org.actanalyzer.database.table.Group;

public class GroupJsonRequest implements JsonRequest<Group> {
	public String name;
	
	@Override
	public Group convertJsonToEntity() {
		Group newGroup = new Group();
		
		newGroup.setName(this.name);
		
		return newGroup;
	}
}
