package com.routines.restapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.routines.restapi.entities.Routine;


/**
 *This class communicates with database, making the transactions.
 */
public interface RoutineRepository extends CrudRepository<Routine, Long> {
	
	public List<Routine> findAll();
	
}
