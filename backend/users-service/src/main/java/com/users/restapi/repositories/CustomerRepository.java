package com.users.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.users.service.commons.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
