package org.actanalyzer.api.request;

import org.actanalyzer.api.json.JsonRequest;
import org.actanalyzer.database.table.User;
import org.actanalyzer.logic.AuthToken;

public class UserJsonRequest implements JsonRequest<User> {
	public String username;
	public String password;
	
	@Override
	public User convertJsonToEntity() {
		User newUser = new User();
		
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setAuthToken(generateAuthToken());
		
		return newUser;
	}
	
	private String generateAuthToken() {
		return new AuthToken(22).getValue();
	}
}
