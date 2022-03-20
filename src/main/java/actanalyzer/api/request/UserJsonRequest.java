package actanalyzer.api.request;

import actanalyzer.api.json.JsonRequest;
import actanalyzer.database.table.User;
import actanalyzer.logic.AuthToken;

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
