package com.users.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commons.users.service.entities.Staff;
import com.users.restapi.services.IStaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private IStaffService iStaffService;
	
	@GetMapping("/")
	public List<Staff> findAll(){
		return iStaffService.findAll();
	}
	
	@GetMapping("/{email}")
	public Staff findByEmail(@PathVariable String email) {
		return iStaffService.findByEmail(email);
	}
	
}
