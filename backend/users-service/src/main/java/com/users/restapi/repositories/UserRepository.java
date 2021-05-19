package com.users.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.commons.entities.service.entities.User;



/**
 *This class communicates with database, making the transactions.
 */
public interface UserRepository extends CrudRepository<User, String> {

	public User findByEmail(String email);
	
}
