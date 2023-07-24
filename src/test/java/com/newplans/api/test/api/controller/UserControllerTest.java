package com.newplans.api.test.api.controller;

import com.newplans.api.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.newplans.api.configuration.Settings.REQUEST_PATH;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private MockMvc request;
	
	@Test
	public void newUser() throws Exception {
		request.perform( 
			post(REQUEST_PATH + "/users/")
				.contentType("application/json") 
				.content("{ \"name\": \"arthur\", \"surname\": \"araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isCreated());
	}

	@Test
	public void newUserNameSpecialChar() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"@Ap2d_arthur\", \"surname\": \"araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void newUserSurnameSpecialChar() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"@Ap2d_araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void newUserEmailInvalid() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"@Ap2d_araujo\", \"email\": \"arthur.araujo@zmake2.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void getAllUsers() throws Exception {
		request.perform( get(REQUEST_PATH + "/users/") )
			.andExpect(status().isOk())
			.andExpect(content().json("[{\"id\":1,\"name\":\"Arthur\",\"surname\":\"Araujo\",\"email\":\"arthur.araujo@tutanota.com\",\"birthdayDate\":\"20-09-2005\"}]"))
			.andReturn();
	}
}
