package com.newplans.api.repository;

import com.newplans.api.database.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByToken(String token);
	Optional<User> findByEmail(String email);
}
