package com.routines.restapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.routines.restapi.entities.RoutinesGroup;

public interface RoutinesGroupRepository extends CrudRepository<RoutinesGroup, Integer> {

	public List<RoutinesGroup> findAll();
	
}
