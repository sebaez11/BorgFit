package com.memberships.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.commons.entities.service.entities.Membership;

@RestController
public class MembershipController {

	@Autowired
	private MembershipRepo repo;
	
	@GetMapping("/{id}")
	public Membership findByUserId(@PathVariable String id) {
		return repo.findByUsers_identificationNumber(id);
	}
	
}
