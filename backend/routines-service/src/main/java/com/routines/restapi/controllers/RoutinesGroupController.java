package com.routines.restapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routines.restapi.models.RoutineResponse;
import com.routines.restapi.services.RoutinesGroupService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class RoutinesGroupController {

	@Autowired
	private RoutinesGroupService routinesGroupService;
	
	@GetMapping("/groups/")
	public ResponseEntity<RoutineResponse> findAll(){
		return routinesGroupService.findAll();
	}
	
}
