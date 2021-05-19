package com.routines.restapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routines.restapi.entities.Workout;
import com.routines.restapi.services.IWorkoutService;


/**
 *Controls the workout requests
 */
@RestController
public class WorkoutController {
	
	@Autowired
	private IWorkoutService iWorkoutService;

	
	/**
	 * 
	 * @param id routine attribute to find workouts relationed with itself.
	 * @return a workout list.
	 */
	@GetMapping("/{id}/workouts")
	public List<Workout> findByRoutinesId(Long id){
		return iWorkoutService.findByRoutines_id(id);
	}
	
}
