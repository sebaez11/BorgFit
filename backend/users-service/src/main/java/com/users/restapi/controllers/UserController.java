package com.users.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.commons.users.service.entities.User;
import com.users.restapi.services.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	
	@GetMapping("/{email}")
	public User findByEmail(@PathVariable String email) {
		return iUserService.findByEmail(email);
	}

}
