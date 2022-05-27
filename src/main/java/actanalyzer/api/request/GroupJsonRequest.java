package actanalyzer.api.request;

import actanalyzer.api.json.JsonRequest;
import actanalyzer.database.table.Group;

public class GroupJsonRequest implements JsonRequest<Group> {
	public String name;
	
	@Override
	public Group convertJsonToEntity() {
		Group newGroup = new Group();
		
		newGroup.setName(this.name);
		
		return newGroup;
	}
}
