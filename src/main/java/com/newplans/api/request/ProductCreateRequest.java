package com.newplans.api.request;

import com.newplans.api.database.entity.Product;
import com.newplans.api.exception.RequestValidationException;

import static java.util.Objects.isNull;

public class ProductCreateRequest {
    public String name;

    public String category;
    public Long price;
    public Long stock;

    public Product toEntity() throws RequestValidationException {
        this.validate();

        Product newProduct = new Product();

        newProduct.setName(name);
        newProduct.setCategory(category.toLowerCase());
        newProduct.setPrice(price);
        newProduct.setStock(stock);

        return newProduct;
    }

    private void validate() throws RequestValidationException {
        if (isNull(name) || name.isEmpty()) {
            throw new RequestValidationException("Name cannot be empty or null");
        }

        if (isNull(category) || category.isEmpty()) {
            throw new RequestValidationException("Category cannot be empty or null");
        }

        if (isNull(price)) {
            throw new RequestValidationException("Price cannot be null");
        }

        if (price.equals((long) 0)) {
            throw new RequestValidationException("Price cannot be 0");
        }

        if (isNull(stock)) {
            throw new RequestValidationException("Stock cannot be null");
        }
    }
}
