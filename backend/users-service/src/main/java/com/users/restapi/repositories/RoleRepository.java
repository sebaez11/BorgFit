package com.users.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.commons.entities.service.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Short> {

	public Role findByName(String name);
	
}
