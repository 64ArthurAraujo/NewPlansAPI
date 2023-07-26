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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc request;

    // CREATE
    @Test
    public void insert() throws Exception {
        request.perform(
                post(REQUEST_PATH + "/products/")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camizeta Confortável\", \"category\": \"camiseta\", \"price\": 500, \"stock\": 1 }")
        ).andExpect(status().isCreated());
    }

    @Test
    public void insertNameEmpty() throws Exception {
        request.perform(
                post(REQUEST_PATH + "/products/")
                        .contentType("application/json")
                        .content("{ \"name\": \"\", \"price\": 500, \"stock\": 1 }")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void insertNameNull() throws Exception {
        request.perform(
                post(REQUEST_PATH + "/products/")
                        .contentType("application/json")
                        .content("{ \"price\": 500, \"stock\": 1 }")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void insertCategoryEmpty() throws Exception {
        request.perform(
                post(REQUEST_PATH + "/products/")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camizeta Confortável\", \"category\"; \"\",  \"price\": 500, \"stock\": 1 }")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void insertCategoryNull() throws Exception {
        request.perform(
                post(REQUEST_PATH + "/products/")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camizeta Confortável\", \"price\": 500, \"stock\": 1 }")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void insertPriceNull() throws Exception {
        request.perform(
                post(REQUEST_PATH + "/products/")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camiseta Confortável\", \"stock\": 1 }")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void insertStockNull() throws Exception {
        request.perform(
                post(REQUEST_PATH + "/products/")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camiseta Confortável\", \"price\": 500 }")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void insertPriceZero() throws Exception {
        request.perform(
                post(REQUEST_PATH + "/products/")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camiseta Confortável\", \"price\": 0, \"stock\": 1 }")
        ).andExpect(status().isBadRequest());
    }

    // READ
    @Test
    public void searchByName() throws Exception {
        request.perform( get(REQUEST_PATH + "/products/search?name=camiseta") )
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Camiseta Confortável\",\"price\":90,\"stock\":10}]"))
                .andReturn();
    }

    @Test
    public void searchNonexistantName() throws Exception {
        request.perform( get(REQUEST_PATH + "/products/search?name=calça") )
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void getById() throws Exception {
        request.perform( get(REQUEST_PATH + "/products/1") )
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getByNonexistentId() throws Exception {
        request.perform( get(REQUEST_PATH + "/products/64") )
                .andExpect(status().isNotFound())
                .andReturn();
    }

    // UPDATE
    @Test
    public void updateName() throws Exception {
        request.perform(
                put(REQUEST_PATH + "/products/1/name")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camiseta Desconfortável\", \"adminToken\": \"4e9394b4d2876b8741b10a\" }")
        ).andExpect(status().isOk());
    }

    @Test
    public void updateNameNonExistentToken() throws Exception {
        request.perform(
                put(REQUEST_PATH + "/products/1/name")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camiseta Desconfortável\", \"adminToken\": \"saoke021\" }")
        ).andExpect(status().isNotFound());
    }

    @Test
    public void updateNameNonAdminToken() throws Exception {
        request.perform(
                put(REQUEST_PATH + "/products/1/name")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camiseta Desconfortável\", \"adminToken\": \"4e9394b42d8741b10a\" }")
        ).andExpect(status().isForbidden());
    }

    @Test
    public void updateNameNonExistentId() throws Exception {
        request.perform(
                put(REQUEST_PATH + "/products/64/name")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camiseta Desconfortável\", \"adminToken\": \"4e9394b4d2876b8741b10a\" }")
        ).andExpect(status().isNotFound());
    }

    @Test
    public void updateNameNameEmpty() throws Exception {
        request.perform(
                put(REQUEST_PATH + "/products/64/name")
                        .contentType("application/json")
                        .content("{ \"name\": \"\", \"adminToken\": \"4e9394b4d2876b8741b10a\" }")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateNameNameNull() throws Exception {
        request.perform(
                put(REQUEST_PATH + "/products/64/name")
                        .contentType("application/json")
                        .content("{ \"adminToken\": \"4e9394b4d2876b8741b10a\" }")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateNameTokenEmpty() throws Exception {
        request.perform(
                put(REQUEST_PATH + "/products/64/name")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camiseta Desconfortável\", \"adminToken\": \"\" }")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void updateNameTokenNull() throws Exception {
        request.perform(
                put(REQUEST_PATH + "/products/64/name")
                        .contentType("application/json")
                        .content("{ \"name\": \"Camiseta Desconfortável\" }")
        ).andExpect(status().isBadRequest());
    }

    // DELETE

}
