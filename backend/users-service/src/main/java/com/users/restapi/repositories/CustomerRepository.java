package com.users.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.commons.users.service.entities.Customer;


public interface CustomerRepository extends CrudRepository<Customer, String> {

	
	public Customer findByEmail(String email);
	
}
