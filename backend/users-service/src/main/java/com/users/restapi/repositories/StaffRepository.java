package com.users.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.commons.users.service.entities.Staff;

public interface StaffRepository extends CrudRepository<Staff, String> {

	public Staff findByEmail(String email);
	
}
