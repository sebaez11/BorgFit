package com.users.restapi.services;

import java.util.List;

import com.commons.users.service.entities.Staff;

public interface IStaffService {

	public List<Staff> findAll();
	public Staff findById(String id);
	public Staff save(Staff customer);
	public void deleteById(String id);
	public Staff findByEmail(String email);
	
}
