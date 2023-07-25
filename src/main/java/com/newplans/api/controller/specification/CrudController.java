package com.newplans.api.controller.specification;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @param <T1> Request
 * @param <T2> Response
 */
public interface CrudController<T1, T2> {
    // CREATE
    ResponseEntity insert(@RequestBody T1 request);

    // READ
    ResponseEntity<List<T2>> getAll();
    ResponseEntity getById(@PathVariable Long id);

    // UPDATE

    // DELETE
}
