package com.users.restapi.services;

import java.util.List;

import com.commons.entities.service.entities.User;


public interface IUserService {
	
	public boolean existsById(String id);
	public boolean existsByEmail(String email);
	public List<User> findAll();
	public User findById(String id);
	public User save(User user);
	public void deleteById(String id);
	public User findByEmail(String email);
	public List<User> findAllByRoleName(String role);
	
}
