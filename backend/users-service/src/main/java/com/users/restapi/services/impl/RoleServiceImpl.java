package com.users.restapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.entities.service.entities.Role;
import com.users.restapi.repositories.RoleRepository;
import com.users.restapi.services.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public Role findById(Integer id) {
		return roleRepository.findById(id);
	}

}
