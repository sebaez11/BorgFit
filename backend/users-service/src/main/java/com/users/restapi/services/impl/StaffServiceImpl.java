package com.users.restapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.users.service.entities.Staff;
import com.users.restapi.repositories.StaffRepository;
import com.users.restapi.services.IStaffService;


@Service
public class StaffServiceImpl implements IStaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	@Override
	public List<Staff> findAll() {
		return (List<Staff>) staffRepository.findAll();
	}

	@Override
	public Staff findById(String id) {
		return staffRepository.findById(id).orElse(null);
	}

	@Override
	public Staff save(Staff customer) {
		return staffRepository.save(customer);
	}

	@Override
	public void deleteById(String id) {
		staffRepository.deleteById(id);
	}

	@Override
	public Staff findByEmail(String email) {
		return staffRepository.findByEmail(email);
	}

}
