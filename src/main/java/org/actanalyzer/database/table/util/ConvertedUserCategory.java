package org.actanalyzer.database.table.util;

public class ConvertedUserCategory {
	private Long id;
	
	private Long idCategory;
	
	private Long idUser;
	
	public ConvertedUserCategory(Long id, Long idCategory, Long idUser, int timesSearched) {
		this.id = id;
		this.idCategory = idCategory;
		this.idUser = idUser;
		this.timesSearched = timesSearched;
	}

	private int timesSearched;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public int getTimesSearched() {
		return timesSearched;
	}

	public void setTimesSearched(int timesSearched) {
		this.timesSearched = timesSearched;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
}
