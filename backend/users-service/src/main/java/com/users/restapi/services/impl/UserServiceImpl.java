package com.users.restapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.entities.service.entities.User;
import com.users.restapi.repositories.UserRepository;
import com.users.restapi.services.IUserService;


/**
 *This represents the logic implementation. 
 *It will really execute the transaction and will call
 *the data access object.
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	
	/**
	 * Get all users on database.
	 */
	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	
	/**
	 * get an user according an specific id.
	 */
	@Override
	public User findById(String id) {
		return userRepository.findById(id).orElse(null);
	}

	/**
	 * @param user - the object to be saved.
	 * @return an user object.
	 */
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * @param id - attribute to find a user and delete it.
	 */
	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

	/**
	 * @param email - attribute to find a user.
	 * @return an User object.
	 */
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}


	@Override
	public List<User> findAllByRoleName(String role) {
		return userRepository.findByRole_name(role);
	}


	@Override
	public boolean existsById(String id) {
		return userRepository.existsById(id);
	}


	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

}
