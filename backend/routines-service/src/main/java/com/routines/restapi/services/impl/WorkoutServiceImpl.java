package com.routines.restapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routines.restapi.entities.Workout;
import com.routines.restapi.repositories.WorkoutRepository;
import com.routines.restapi.services.IWorkoutService;

@Service
public class WorkoutServiceImpl implements IWorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Override
	public List<Workout> findAll() {
		return (List<Workout>) workoutRepository.findAll();
	}

	@Override
	public Optional<Workout> findById(Long id) {
		return workoutRepository.findById(id);
	}

	@Override
	public Workout save(Workout workout) {
		return workoutRepository.save(workout);
	}

	@Override
	public void deleteById(Long id) {
		workoutRepository.deleteById(id);
	}
	
	@Override
	public List<Workout> findByRoutines_id(Long id){
		return workoutRepository.findByRoutines_id(id);
	}

}
