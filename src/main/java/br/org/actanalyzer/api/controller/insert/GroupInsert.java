package br.org.actanalyzer.api.controller.insert;

import static br.org.actanalyzer.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import br.org.actanalyzer.api.request.GroupJsonRequest;
import br.org.actanalyzer.api.response.GroupJsonResponse;
import br.org.actanalyzer.api.service.implementation.GroupServiceInterface;
import br.org.actanalyzer.database.table.Group;

@RestController
@RequestMapping(path = REQUEST_PATH_INSERT)
public class GroupInsert {
	@Autowired
	private GroupServiceInterface groupService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/groups/", consumes = "application/json")
	public ResponseEntity<GroupJsonResponse> createGroup(@RequestBody GroupJsonRequest jsonRequest) {
		Group newCreatedGroup = groupService.insert(jsonRequest.convertJsonToEntity());
		
		return new ResponseEntity<>(new GroupJsonResponse(newCreatedGroup), HttpStatus.CREATED);
	}
}
