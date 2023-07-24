package com.newplans.api.request;

import com.newplans.api.database.entity.User;

public class UserCreateRequest  {
	public String name;
	public String surname;
	public String birthdayDate;
	public String email;
	public String password;

	public User toEntity() throws Exception {
		this.validate();

		User newUser = new User();
		
		newUser.setName(name);
		newUser.setSurname(surname);
		newUser.setBirthdayDate(birthdayDate);
		newUser.setEmail(email);
		newUser.setPassword(password);
		
		return newUser;
	}

	private void validate() throws Exception {

	}
}
