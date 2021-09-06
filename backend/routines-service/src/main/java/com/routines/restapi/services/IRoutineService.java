package com.routines.restapi.services;

import java.util.List;

import com.routines.restapi.entities.Routine;

/**
 *Represents an agreement with the class implements it.
 */
public interface IRoutineService {

	public List<Routine> findAllByRoutinesGroupId(Short id);
	public Routine findRoutineById(Integer id);
	
}
