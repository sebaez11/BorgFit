package com.users.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.restapi.services.ICustomerService;
import com.users.service.commons.entities.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private ICustomerService iCustomerService;
	
	@PostMapping("/")
	public Customer save(@RequestBody Customer customer) {
		return iCustomerService.save(customer);
	}
	
	@GetMapping("/")
	public List<Customer> findAll(){
		return iCustomerService.findAll();
	}
}
