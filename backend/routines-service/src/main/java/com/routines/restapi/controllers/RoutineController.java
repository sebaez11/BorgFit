package com.routines.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.routines.restapi.entities.Routine;
import com.routines.restapi.services.IRoutineService;


/**
 *controls the routine requests.
 */
@RestController
public class RoutineController {

	@Autowired
	private IRoutineService iRoutineService;

	
	/**
	 * 
	 * @param id routine attribute to find a routine object.
	 * @return a routine object.
	 */
	@GetMapping("/{id}")
	public Routine findWorkoutsByRoutineId(@PathVariable Long id){
		return iRoutineService.findById(id);
	}
	
	
	/**
	 * 
	 * @return a routine list.
	 */
	@GetMapping("/")
	public List<Routine> getAll(){
		return iRoutineService.findAll();
	}
	
}
