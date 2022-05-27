package br.org.actanalyzer.api.request;

import br.org.actanalyzer.api.json.JsonRequest;
import br.org.actanalyzer.database.table.Category;

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
