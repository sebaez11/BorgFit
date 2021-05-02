package com.users.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.commons.users.service.entities.User;

public interface UserRepository extends CrudRepository<User, String> {

	public User findByEmail(String email);
	
}
