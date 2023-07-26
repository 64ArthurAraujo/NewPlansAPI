package com.newplans.api.response.user;

import com.newplans.api.database.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserCreatedResponse {
	private Long id;
	private String token;
	
	public UserCreatedResponse(User user) {
		this.id = user.getId();
		this.token = user.getToken();
	}
}
