package com.routines.restapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.routines.restapi.entities.Workout;


/**
 *This class communicates with database, making the transactions.
 */
public interface WorkoutRepository extends CrudRepository<Workout, Long> {

}
