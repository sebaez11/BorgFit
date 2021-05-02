package com.users.restapi.services;

import java.util.List;

import com.commons.users.service.entities.User;

public interface IUserService {
	
	public List<User> findAll();
	public User findById(String id);
	public User save(User user);
	public void deleteById(String id);
	public User findByEmail(String email);
}
