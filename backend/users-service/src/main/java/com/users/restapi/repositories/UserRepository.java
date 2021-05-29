package com.users.restapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.commons.entities.service.entities.User;



/**
 *This class communicates with database, making the transactions.
 */
public interface UserRepository extends CrudRepository<User, String> {

	public boolean existsByEmail(String email);
	public boolean existsByIdentificationNumberAndActiveTrue(String id);
	public User findByEmail(String email);
	public List<User> findByActiveTrueAndRole_name(String role);
	
}
