package br.org.actanalyzer.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.actanalyzer.database.table.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByUsername(String username);
	User findByAuthToken(String auth_token);
}
