package com.users.restapi.services;

import java.util.List;

import com.users.service.commons.entities.Customer;

public interface ICustomerService {
	
	public List<Customer> findAll();
	public Customer findById(String id);
	public Customer save(Customer customer);
	public void deleteById(String id);
	
}
