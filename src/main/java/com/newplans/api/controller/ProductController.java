package com.newplans.api.controller;

import com.newplans.api.configuration.Settings;
import com.newplans.api.controller.specification.CrudController;
import com.newplans.api.database.entity.Product;
import com.newplans.api.exception.NoSuchEntryException;
import com.newplans.api.exception.RequestValidationException;
import com.newplans.api.request.ProductCreateRequest;
import com.newplans.api.service.specification.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = Settings.REQUEST_PATH)
public class ProductController implements CrudController<ProductCreateRequest, Product> {
    @Autowired
    private ProductServiceInterface service;

    @RequestMapping(method = RequestMethod.POST, path = "/products", consumes = "application/json")
    @Override
    public ResponseEntity insert(@RequestBody ProductCreateRequest request) {
        try {
            service.insert(request.toEntity());
            return new ResponseEntity<>(CREATED);
        } catch (RequestValidationException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    @Override
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
    @Override
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), OK);
        } catch (NoSuchEntryException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }
}
