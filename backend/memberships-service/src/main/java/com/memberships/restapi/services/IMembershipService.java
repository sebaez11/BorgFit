package com.memberships.restapi.services;

import java.util.Collection;

import org.json.JSONObject;

import com.memberships.restapi.dto.IMembershipDto;
import com.memberships.restapi.dto.MembershipDto;

public interface IMembershipService {

	public Collection<IMembershipDto> findByUserId(String id);
	
}
