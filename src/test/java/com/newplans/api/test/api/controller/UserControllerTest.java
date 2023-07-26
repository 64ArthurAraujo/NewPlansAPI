package com.newplans.api.test.api.controller;

import com.newplans.api.Application;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private MockMvc request;


	// CREATE
	@Test
	public void insert() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isCreated());
	}

	@Test
	public void insertNameSpecialChar() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"@Ap2d_arthur\", \"surname\": \"araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertNameEmpty() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"\", \"surname\": \"araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertNameNull() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"surname\": \"araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertSurnameSpecialChar() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"@Ap2d_araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertSurnameEmpty() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertSurnameNull() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertEmailInvalid() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"araujo\", \"email\": \"arthur.araujo@zmake2.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertEmailEmpty() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"araujo\", \"email\": \"\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertEmailNull() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"araujo\", \"password\": \"S_enha64\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertPasswordEmpty() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"araujo\", \"password\": \"\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertPasswordNull() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"araujo\", \"birthdayDate\": \"01-02-2003\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertBirthdayDateEmpty() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\", \"birthdayDate\": \"\" }")
		).andExpect(status().isBadRequest());
	}

	@Test
	public void insertBirthdayDateNull() throws Exception {
		request.perform(
				post(REQUEST_PATH + "/users/")
						.contentType("application/json")
						.content("{ \"name\": \"arthur\", \"surname\": \"araujo\", \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\" }")
		).andExpect(status().isBadRequest());
	}

	// READ
	@Test
	public void getAll() throws Exception {
		request.perform( get(REQUEST_PATH + "/users/") )
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"name\":\"Arthur\",\"surname\":\"Araujo\",\"email\":\"arthur.araujo@tutanota.com\",\"birthdayDate\":\"20-09-2005\"},{\"id\":2,\"name\":\"conta\",\"surname\":\"2\",\"email\":\"conta2@tutanota.com\",\"birthdayDate\":\"20-09-2005\"}]"))
				.andReturn();
	}

	@Test
	public void getById() throws Exception {
		request.perform( get(REQUEST_PATH + "/users/1") )
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Arthur\",\"surname\":\"Araujo\",\"email\":\"arthur.araujo@tutanota.com\",\"birthdayDate\":\"20-09-2005\"}"))
				.andReturn();
	}

	@Test
	public void getByInexistentId() throws Exception {
		request.perform( get(REQUEST_PATH + "/users/64") )
				.andExpect(status().isNotFound())
				.andReturn();
	}

	@Test
	public void login() throws Exception {
		request.perform(
						post(REQUEST_PATH + "/users/login")
								.contentType("application/json")
								.content("{ \"email\": \"arthur.araujo@gmail.com\", \"password\": \"S_enha64\" }")
				)
				.andExpect(status().isOk());
	}

	// UPDATE

	// DELETE
}
