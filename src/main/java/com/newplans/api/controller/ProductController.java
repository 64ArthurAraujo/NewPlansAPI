package com.newplans.api.controller;

import com.newplans.api.configuration.Settings;
import com.newplans.api.database.entity.Product;
import com.newplans.api.exception.NoSuchEntryException;
import com.newplans.api.exception.RequestValidationException;
import com.newplans.api.request.product.CreateRequest;
import com.newplans.api.request.product.NameUpdateRequest;
import com.newplans.api.request.user.LoginRequest;
import com.newplans.api.service.specification.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = Settings.REQUEST_PATH)
public class ProductController {
    @Autowired
    private ProductServiceInterface service;

    // CREATE
    @RequestMapping(method = RequestMethod.POST, path = "/products", consumes = "application/json")
    public ResponseEntity create(@RequestBody CreateRequest request) {
        try {
            service.insert(request.toEntity());
        } catch (RequestValidationException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }

        return new ResponseEntity<>(CREATED);
    }

    // READ
    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(service.getAllProducts(), OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products/search")
    public ResponseEntity searchByName(@RequestParam String name) {
        try {
            return new ResponseEntity<>(service.getProductsByName(name), OK);
        } catch (NoSuchEntryException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), OK);
        } catch (NoSuchEntryException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }

    // UPDATE
    @RequestMapping(method = RequestMethod.PUT, path = "/products/{id}/name")
    public ResponseEntity updateName(
            @PathVariable Long id,
            @RequestBody NameUpdateRequest request
    ) {
        Product product;

       try {
           product = service.updateProductName(id, request.getName(), request.getAdminToken());
       } catch (Exception e) {
            if (e.getMessage().startsWith("Permission denied")) {
                return new ResponseEntity<>(e.getMessage(), FORBIDDEN);
            }

            if (e.getMessage().startsWith("Request validation")) {
                return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
            }

            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
       }

        return new ResponseEntity<>(product, OK);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, path = "/products/{id}")
    public ResponseEntity delete(@RequestBody LoginRequest request) {
        return null;
    }
}
