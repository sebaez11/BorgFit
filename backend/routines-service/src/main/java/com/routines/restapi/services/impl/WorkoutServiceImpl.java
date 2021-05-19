package com.routines.restapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routines.restapi.entities.Workout;
import com.routines.restapi.repositories.WorkoutRepository;
import com.routines.restapi.services.IWorkoutService;


/**
 *Call the RoutineRepository to execute the transactions.
 */
@Service
public class WorkoutServiceImpl implements IWorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;
	
	
	/**
	 * find all workouts.
	 * @return workout list.
	 */
	@Override
	public List<Workout> findAll() {
		return (List<Workout>) workoutRepository.findAll();
	}

	
	/**
	 * find a workout by its id.
	 * @param id workout attribute.
	 * @return returns a workout found by its id
	 */
	@Override
	public Optional<Workout> findById(Long id) {
		return workoutRepository.findById(id);
	}

	
	/**
	 * save a workout.
	 * @param workout object to be saved.
	 * @return returns the created object.
	 */
	@Override
	public Workout save(Workout workout) {
		return workoutRepository.save(workout);
	}

	
	/**
	 * delete a workout by its id.
	 * @param id workout attribute.
	 */
	@Override
	public void deleteById(Long id) {
		workoutRepository.deleteById(id);
	}
	
	
	/**
	 *find workouts by routines id.
	 *@param id routine attribute.
	 *@return workout list.
	 */
	@Override
	public List<Workout> findByRoutines_id(Long id){
		return workoutRepository.findByRoutines_id(id);
	}

}
