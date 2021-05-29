package com.routines.restapi.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routines.restapi.repositories.WorkoutRepository;
import com.routines.restapi.services.IWorkoutService;


/**
 *Call the RoutineRepository to execute the transactions.
 */
@Service
public class WorkoutServiceImpl implements IWorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;
		

}
