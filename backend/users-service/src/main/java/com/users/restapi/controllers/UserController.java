package com.users.restapi.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.commons.entities.service.entities.User;
import com.users.restapi.dto.CreateUserDto;
import com.users.restapi.dto.UserDto;
import com.users.restapi.models.UserResponse;
import com.users.restapi.repositories.UserRepository;
import com.users.restapi.services.UserService;


/**
 *UserController controls the user requests.
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepo;
	
	/**
	 * 
	 * @param user - receives an User object to be saved
	 * @return Json Object with message according to the transaction.
	 */
	@PostMapping("/customers/")
	public ResponseEntity<UserResponse> saveCustomer(@RequestBody CreateUserDto userDto){
		User user = modelMapper.map(userDto, User.class);
		return userService.save(user , "ROLE_CUSTOMER");
	}
	
	/**
	 * 
	 * @param user - receives an User object to be saved
	 * @return Json Object with message according to the transaction.
	 */
	@PostMapping("/coaches/")
	public ResponseEntity<UserResponse> saveCoach(@RequestBody CreateUserDto userDto){
		User user = modelMapper.map(userDto, User.class);
		return userService.save(user , "ROLE_COACH");
	}
	
	/**
	 * 
	 * @param user - receives an User object to be saved
	 * @return Json Object with message according to the transaction.
	 */
	@PostMapping("/administratives/")
	public ResponseEntity<UserResponse> saveAdministrative(@RequestBody CreateUserDto userDto){
		User user = modelMapper.map(userDto, User.class);
		return userService.save(user , "ROLE_ADMINISTRATIVE");
	}
	
	/**
	 * 
	 * @return Json Object with message according to the transaction.
	 */
	@GetMapping("/customers/")
	public ResponseEntity<UserResponse> findAllCustomers(){	
		return userService.findAllByRoleName("ROLE_CUSTOMER");
	}
	
	/**
	 * 
	 * @return Json Object with message according to the transaction.
	 */
	@GetMapping("/coaches/")
	public ResponseEntity<UserResponse> findAllCoaches(){	
		return userService.findAllByRoleName("ROLE_COACH");
	}
	
	/**
	 * 
	 * @return Json Object with message according to the transaction.
	 */
	@GetMapping("/administratives/")
	public ResponseEntity<UserResponse> findAllAdministratives(){	
		return userService.findAllByRoleName("ROLE_ADMINISTRATIVE");
	}

	/**
	 * 
	 * @param email - user entity's attribute
	 * @return an User object that matches with the email param.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> findById(@PathVariable String id) {
		return userService.findById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserResponse> update(@RequestBody UserDto userDto , @PathVariable String id){
		User user = modelMapper.map(userDto, User.class);
		return userService.update(user, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserResponse> deactivate(@PathVariable String id){
		return userService.deactivate(id);
	}
	
	@GetMapping("/users/{id}")
	public boolean existsById(@PathVariable String id) {
		return userRepo.existsByIdentificationNumber(id);
	}

}
