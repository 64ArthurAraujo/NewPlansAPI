package com.newplans.api.database.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "usuario")
public class User implements Serializable {
	
	private static final long serialVersionUID = 4555915248916629355L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String name;

	@Column(name = "sobrenome")
	private String surname;

	@Column(name = "nascimento_data")
	private String birthdayDate;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "senha")
	private String password;
	
	@Column(name = "token", unique = true)
	private String token;

	@Column(name = "admin")
	@Getter(value = AccessLevel.NONE)
	private boolean admin;

	public boolean isAdmin() {
		return admin;
	}
}
