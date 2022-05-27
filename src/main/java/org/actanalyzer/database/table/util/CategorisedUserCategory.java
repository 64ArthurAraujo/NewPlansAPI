package org.actanalyzer.database.table.util;

public class CategorisedUserCategory {
	private Long id;
	
	private String categoryName;
	
	private String userName;
	
	private int timesSearched;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTimesSearched() {
		return timesSearched;
	}

	public void setTimesSearched(int timesSearched) {
		this.timesSearched = timesSearched;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
