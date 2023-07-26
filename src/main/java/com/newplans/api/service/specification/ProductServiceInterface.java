package com.newplans.api.service.specification;

import com.newplans.api.database.entity.Product;
import com.newplans.api.exception.NoSuchEntryException;
import com.newplans.api.exception.PermissionDeniedException;

import java.util.List;

public interface ProductServiceInterface extends ServiceInterface<Product, Product> {
    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category) throws NoSuchEntryException;

    List<Product> getProductsByName(String name) throws NoSuchEntryException;

    Product updateProductName(Long id, String newName, String token) throws NoSuchEntryException, PermissionDeniedException;
}
