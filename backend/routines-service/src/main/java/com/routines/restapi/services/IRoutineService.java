package com.routines.restapi.services;

import java.util.List;

import com.routines.restapi.entities.Routine;
import com.routines.restapi.entities.Workout;

/**
 *Represents an agreement with the class implements it.
 */
public interface IRoutineService {

	public List<Routine> findAll();
	public Routine findById(Long id);
	public Routine save(Routine routine);
	public void deleteById(Long id);
	
}
