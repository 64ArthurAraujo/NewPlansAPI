package actanalyzer.api.request;

import actanalyzer.api.json.JsonRequest;
import actanalyzer.database.table.Category;

public class CategoryJsonRequest implements JsonRequest<Category> {
	public String name;
	public Long groupId;
	
	@Override
	public Category convertJsonToEntity() {
		Category newCategory = new Category();
		
		newCategory.setName(this.name);
		newCategory.setGroupId(this.groupId);
		
		return newCategory;
	}
	
}
