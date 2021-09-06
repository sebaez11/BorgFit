package com.memberships.restapi.controllers;

import java.util.Collection;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.memberships.restapi.dto.IMembershipDto;
import com.memberships.restapi.dto.MembershipDto;
import com.memberships.restapi.models.MembershipResponse;
import com.memberships.restapi.repositories.MembershipRepository;
import com.memberships.restapi.services.MembershipService;

@RestController
public class MembershipController {

	@Autowired
	private MembershipService membershipService;
	
	@Autowired
	private MembershipRepository repo;
	
	@GetMapping("users/{id}")
	public ResponseEntity<MembershipResponse> findByUserId(@PathVariable String id){
		return membershipService.findByUserId(id);
	}
	
	@GetMapping("ejemplito/{id}")
	public Collection<IMembershipDto> ejemplito(@PathVariable String id) {
		return repo.findByUserId(id);
	}
	
}
