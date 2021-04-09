package com.routines.restapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.routines.restapi.entities.Routine;

public interface RoutineRepository extends CrudRepository<Routine, Long> {
		
}
