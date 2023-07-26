package com.newplans.api.service;

import com.newplans.api.database.entity.Product;
import com.newplans.api.database.entity.User;
import com.newplans.api.exception.NoSuchEntryException;
import com.newplans.api.exception.PermissionDeniedException;
import com.newplans.api.repository.ProductRepository;
import com.newplans.api.service.specification.ProductServiceInterface;
import com.newplans.api.service.specification.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private UserServiceInterface userService;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) throws NoSuchEntryException {
        List<Product> productsFound = new ArrayList<>(repository.findByCategory(category.toLowerCase()));

        if (productsFound.isEmpty()) {
            throw new NoSuchEntryException("No entries found in category: '" + category + "'");
        }

        return productsFound;
    }

    @Override
    public Product getById(Long id) throws NoSuchEntryException {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            return product.get();
        }

        throw new NoSuchEntryException("No entry found with id: '" + id + "'");
    }

    @Override
    public List<Product> getProductsByName(String name) throws NoSuchEntryException {
        List<Product> productsFound = new ArrayList<>();

        for (Product entry : repository.findAll()) {
            if (entry.getName().toLowerCase().startsWith(name.toLowerCase())) {
                productsFound.add(entry);
            }
        }

        if (productsFound.isEmpty()) {
            throw new NoSuchEntryException("No entries found with name: '" + name + "'");
        }

        return productsFound;
    }

    @Override
    public Product updateProductName(Long id, String newName, String token) throws NoSuchEntryException, PermissionDeniedException {
        User userTryingToUpdate = userService.getByToken(token);

        if (!userTryingToUpdate.isAdmin()) {
            throw new PermissionDeniedException("Insufficient privileges to update product name");
        }

        Product productToUpdate = this.getById(id);
        productToUpdate.setName(newName);

        return repository.save(productToUpdate);
    }

    @Override
    public Product insert(Product entity) {
        return repository.save(entity);
    }
}
