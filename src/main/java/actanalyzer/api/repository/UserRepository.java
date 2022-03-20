package actanalyzer.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import actanalyzer.database.table.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByUsername(String username);
}
