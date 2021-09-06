package com.routines.restapi.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.routines.restapi.entities.Routine;
import com.routines.restapi.models.RoutineResponse;
import com.routines.restapi.repositories.RoutineRepository;
import com.routines.restapi.services.RoutineService;


/**
 *controls the routine requests.
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class RoutineController {
	
	@Autowired
	private RoutineRepository routineRepo;
	
	@Autowired
	private RoutineService routineService;
	
	/*
	@GetMapping("/users/{id}")
	public ResponseEntity<RoutineResponse> findAllByUserId(@PathVariable String id){
		return routineService.findAllByUserId(id);
	}
	*/
	
	@GetMapping("/")
	public List<Routine> findAll(){
		return routineRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoutineResponse> findById(@PathVariable Integer id) {
		return routineService.findById(id);
	}
	
	@GetMapping("/group/{id}")
	public ResponseEntity<RoutineResponse> findAllByRoutinesGroupId(@PathVariable Short id){
		return routineService.findAllByRoutinesGroupId(id);
	}
	
}
