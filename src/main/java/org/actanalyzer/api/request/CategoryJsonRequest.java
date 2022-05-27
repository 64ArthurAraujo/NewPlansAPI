package org.actanalyzer.api.request;

import org.actanalyzer.api.json.JsonRequest;
import org.actanalyzer.database.table.Category;

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
