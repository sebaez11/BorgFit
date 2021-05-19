package com.routines.restapi.services;

import java.util.List;
import java.util.Optional;

import com.routines.restapi.entities.Workout;


/**
 *Represents an agreement with the class implements it.
 */
public interface IWorkoutService {

	public List<Workout> findAll();
	public Optional<Workout> findById(Long id);
	public Workout save(Workout workout);
	public void deleteById(Long id);
	public List<Workout> findByRoutines_id(Long id);
	
}
