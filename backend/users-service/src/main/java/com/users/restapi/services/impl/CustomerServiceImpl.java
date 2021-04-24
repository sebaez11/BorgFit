package com.users.restapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.restapi.repositories.CustomerRepository;
import com.users.restapi.services.ICustomerService;
import com.users.service.commons.entities.Customer;


@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer findById(String id) {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(String id) {
		customerRepository.deleteById(id);
	}

}
