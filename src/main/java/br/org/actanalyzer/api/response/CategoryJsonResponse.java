package br.org.actanalyzer.api.response;

import br.org.actanalyzer.database.table.Category;

public class CategoryJsonResponse {
	private Long id;
	private String name;
	private Long groupId;	
	
	public CategoryJsonResponse(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.groupId = category.getGroupId();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
