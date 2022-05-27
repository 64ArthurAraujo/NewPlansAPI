package org.actanalyzer.api.controller.insert;

import static org.actanalyzer.api.configuration.Settings.REQUEST_PATH_INSERT;

import org.actanalyzer.api.request.GroupJsonRequest;
import org.actanalyzer.api.response.GroupJsonResponse;
import org.actanalyzer.api.service.implementation.GroupServiceInterface;
import org.actanalyzer.database.table.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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
