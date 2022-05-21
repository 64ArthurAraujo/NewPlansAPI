package actanalyzer.api.controller.retrieve;

import static actanalyzer.api.configuration.Settings.REQUEST_PATH_RETRIEVE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import actanalyzer.api.service.implementation.UserServiceInterface;
import actanalyzer.database.table.User;

@RestController
@RequestMapping(path = REQUEST_PATH_RETRIEVE)
public class UserRetrieve {
	@Autowired
	private UserServiceInterface userService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/")
	public ResponseEntity<Iterable<User>> getUsers() {
		
		return new ResponseEntity<Iterable<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
}
