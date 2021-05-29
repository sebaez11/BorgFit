package com.routines.restapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.routines.restapi.services.IWorkoutService;


/**
 *Controls the workout requests
 */
@RestController
public class WorkoutController {
	
	@Autowired
	private IWorkoutService iWorkoutService;

	
}
