package com.newplans.api.response.user;

import com.newplans.api.database.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatedResponse {
	private Long id;
	private String token;
	
	public CreatedResponse(User user) {
		this.id = user.getId();
		this.token = user.getToken();
	}
}
