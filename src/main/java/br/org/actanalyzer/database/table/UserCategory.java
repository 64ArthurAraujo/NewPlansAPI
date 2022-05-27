package br.org.actanalyzer.database.table;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "usuario_categoria")
public class UserCategory implements Serializable {
	
	private static final long serialVersionUID = 157514389456606351L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name_categoria")
	private String categoryName;
	
	@Column(name = "token_usuario")
	private String userToken;
	
	@Column(name = "times_searched")
	private int timesSearched;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public int getTimesSearched() {
		return timesSearched;
	}

	public void setTimesSearched(int timesSearched) {
		this.timesSearched = timesSearched;
	}
	
}
