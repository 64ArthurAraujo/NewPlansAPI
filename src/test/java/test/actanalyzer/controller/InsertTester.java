package test.actanalyzer.controller;

import static actanalyzer.api.configuration.Settings.REQUEST_PATH_INSERT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import actanalyzer.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class InsertTester {
	
	@Autowired
	private MockMvc request;
	
	@Test
	public void insertNewUser() throws Exception {
		request.perform( 
			post(REQUEST_PATH_INSERT + "/users/")
				.contentType("application/json") 
				.content("{ \"username\": \"TestUser\", \"password\": \"TestUserPassword\" }")
		)
		.andExpect(status().isCreated());
	}
		
	@Test
	public void insertNewGroup() throws Exception {
		request.perform(
			post(REQUEST_PATH_INSERT + "/groups/")
				.contentType("application/json")
				.content("{ \"name\": \"TestGroup\" }")
		)
		.andExpect(status().isCreated());
	}
	
	@Test
	public void insertNewCategory() throws Exception {
		request.perform(
			post(REQUEST_PATH_INSERT + "/categories/")
			.contentType("application/json")
			.content("{\"name\": \"TestCategory\", \"idGroup\": 1}")
		)
		.andExpect(status().isCreated());
	}
	
	@Test
	public void insertNewUserCategoryRelation() throws Exception {
		request.perform(
			post(REQUEST_PATH_INSERT + "/users/categories/")
				.contentType("application/json")
				.content("{ \"categoryName\": \"Tecnologia\", \"userToken\": \"4e9394b4d2876b8741b10a\" }")
		)
		.andExpect(status().isCreated());
	}
}
