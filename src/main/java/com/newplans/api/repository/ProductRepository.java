package com.newplans.api.repository;

import com.newplans.api.database.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);

    List<Product> findByCategory(String category);
}
