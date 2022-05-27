package test.actanalyzer.controller;

import static actanalyzer.api.configuration.Settings.REQUEST_PATH_RETRIEVE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
public class RetrieveTester {
	
	@Autowired
	private MockMvc request;
	
	@Test
	public void getAllUsers() throws Exception {
		request.perform( get(REQUEST_PATH_RETRIEVE + "/users/") )
			.andExpect(status().isOk())
			.andExpect(content().json("[{\"id\":1,\"username\":\"Arthur\",\"password\":\"senha\",\"authToken\":\"4e9394b4d2876b8741b10a\"}]"))
			.andReturn();
	}
	
	@Test
	public void getAllGroups() throws Exception {
		request.perform( get(REQUEST_PATH_RETRIEVE + "/groups/") )
			.andExpect(status().isOk())
			.andExpect(content().json("[{\"id\":1,\"name\":\"Tecnologia\"}]"))
			.andReturn();
	}
	
	@Test
	public void getAllCategories() throws Exception {
		request.perform( get(REQUEST_PATH_RETRIEVE + "/categories/") )
			.andExpect(status().isOk())
			.andExpect(content().json("[{\"id\":1,\"name\":\"Programação\",\"groupId\":1},{\"id\":2,\"name\":\"Design Patterns\",\"groupId\":1}]"))
			.andReturn();
	}
	
	@Test
	public void getUserInformationById() throws Exception {
		request.perform( get(REQUEST_PATH_RETRIEVE + "/users/1") )
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"username\":\"Arthur\",\"password\":\"senha\",\"authToken\":\"4e9394b4d2876b8741b10a\"}"))
			.andReturn();
	}
	
	@Test
	public void getUserTotalSearches() throws Exception {
		request.perform( get(REQUEST_PATH_RETRIEVE + "/users/1/searches/total") )
			.andExpect(status().isOk())
			.andExpect(content().string("0"))
			.andReturn();
	}
	
	@Test
	public void getUserCategorisedSearches() throws Exception {
		request.perform( get(REQUEST_PATH_RETRIEVE + "/users/1/searches/categorised") )
			.andExpect(status().isOk())
			.andReturn();
	}
}
