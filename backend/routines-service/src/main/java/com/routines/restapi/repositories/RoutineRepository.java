package com.routines.restapi.repositories;


import java.util.List;

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
	
	public List<Routine> findByUsers_identificationNumber(String id);
	public List<Routine> findAllByRoutinesGroupId(Short id);
	public List<Routine> findAll();
	
	@Query("SELECT r FROM Routine r where r.id = ?1")
	public Routine findRoutineById(Integer id);
	
}
