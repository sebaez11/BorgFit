package com.users.restapi.services;

import com.commons.entities.service.entities.Role;

public interface IRoleService {

	public Role findByName(String name);
	public Role findById(Integer id);
	
}
