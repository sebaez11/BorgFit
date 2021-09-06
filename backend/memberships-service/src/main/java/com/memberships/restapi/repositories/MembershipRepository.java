package com.memberships.restapi.repositories;

import java.util.Collection;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.commons.entities.service.entities.Membership;
import com.memberships.restapi.dto.IMembershipDto;
import com.memberships.restapi.dto.MembershipDto;

public interface MembershipRepository extends CrudRepository<Membership, Integer> {

	@Query(value = "SELECT mt.name as name, mt.cost as cost, m.active as active from memberships as m JOIN memberships_type as mt ON m.type_id = mt.id JOIN users as u ON m.id = u.membership_id WHERE u.identification_number = ?1", nativeQuery = true)
	public Collection<IMembershipDto> findByUserId(String id);
	
}
