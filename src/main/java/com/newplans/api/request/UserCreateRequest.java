package com.newplans.api.request;

import com.newplans.api.database.entity.User;
import com.newplans.api.exception.RequestValidationException;

import static com.newplans.api.security.RequestValidation.hasSpecialCharacters;
import static com.newplans.api.security.RequestValidation.invalidEmail;
import static java.util.Objects.isNull;

public class UserCreateRequest  {
	public String name;
	public String surname;
	public String birthdayDate;
	public String email;
	public String password;

	public User toEntity() throws RequestValidationException {
		this.validate();

		User newUser = new User();
		
		newUser.setName(name);
		newUser.setSurname(surname);
		newUser.setBirthdayDate(birthdayDate);
		newUser.setEmail(email);
		newUser.setPassword(password);
		
		return newUser;
	}

	private void validate() throws RequestValidationException {
		if (isNull(name) || name.isEmpty()) {
			throw new RequestValidationException("Name cannot be empty or null");
		}
		if (hasSpecialCharacters(name)) {
			throw new RequestValidationException("Name cannot contain special characters");
		}

		if (isNull(surname) || surname.isEmpty()){
			throw new RequestValidationException("Surname cannot be empty or null");
		}
		if (hasSpecialCharacters(surname)) {
			throw new RequestValidationException("Surname cannot contain special characters");
		}

		if (isNull(email) || email.isEmpty()) {
			throw new RequestValidationException("Email cannot be empty or null");
		}
		if (invalidEmail(email)) {
			throw new RequestValidationException("Email is invalid");
		}

		if (isNull(password) || password.isEmpty()) {
			throw new RequestValidationException("Password cannot be empty or null");
		}

		if (isNull(birthdayDate) || birthdayDate.isEmpty()) {
			throw new RequestValidationException("birthdayDate cannot be empty or null");
		}
	}
}
