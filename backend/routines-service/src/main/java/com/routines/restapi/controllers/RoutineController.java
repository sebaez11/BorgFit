package com.routines.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.routines.restapi.entities.Routine;
import com.routines.restapi.services.IRoutineService;

@RestController
public class RoutineController {

	@Autowired
	private IRoutineService iRoutineService;

	@GetMapping("/{id}")
	public Routine findWorkoutsByRoutineId(@PathVariable Long id){
		return iRoutineService.findById(id);
	}
	
	@GetMapping("/")
	public List<Routine> getAll(){
		return iRoutineService.findAll();
	}
	
}
