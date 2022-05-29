package org.actanalyzer.database.table;

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
	
	@Column(name = "interest_rate")
	private int interestRate;

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

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	
	public void addInterest(int interestIncrease) {
		this.interestRate += interestIncrease;
	}
	
}
