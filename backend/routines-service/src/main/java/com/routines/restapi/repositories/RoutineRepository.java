package com.routines.restapi.repositories;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.routines.restapi.entities.Routine;


/**
 *This class communicates with database, making the transactions.
 */
public interface RoutineRepository extends CrudRepository<Routine, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO routines_users (routine_id , user_id) VALUES(?1 , ?2)" , nativeQuery = true)
	public void addRoutineToUser(Integer routine_id , String user_id);
	
}
