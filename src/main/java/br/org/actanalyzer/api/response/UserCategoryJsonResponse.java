package br.org.actanalyzer.api.response;

import br.org.actanalyzer.database.table.util.ConvertedUserCategory;

public class UserCategoryJsonResponse {
	private Long id;
	private Long idCategory;
	private Long idUser;
	private int timesSearched;
	
	public UserCategoryJsonResponse(ConvertedUserCategory category) {
		this.id = category.getId();
		this.idCategory = category.getIdCategory();
		this.idUser = category.getIdUser();
		this.timesSearched = category.getTimesSearched();
	}

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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public int getTimesSearched() {
		return timesSearched;
	}

	public void setTimesSearched(int timesSearched) {
		this.timesSearched = timesSearched;
	}
}
