package com.routines.restapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.routines.restapi.entities.Workout;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {

	public List<Workout> findByRoutines_id(Long id);
	
}
