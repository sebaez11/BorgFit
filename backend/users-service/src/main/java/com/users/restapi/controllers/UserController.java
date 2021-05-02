package com.users.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commons.users.service.entities.User;
import com.users.restapi.models.UserResponse;
import com.users.restapi.services.IUserService;
import com.users.restapi.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/{email}")
	public User findByEmail(@PathVariable String email) {
		return iUserService.findByEmail(email);
	}
	
	@PostMapping("/")
	public ResponseEntity<UserResponse> save(@RequestBody User user){
		return userService.save(user);
	}

}
