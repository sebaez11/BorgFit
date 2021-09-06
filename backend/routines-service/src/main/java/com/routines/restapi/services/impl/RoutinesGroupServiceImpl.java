package com.routines.restapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routines.restapi.entities.RoutinesGroup;
import com.routines.restapi.repositories.RoutinesGroupRepository;
import com.routines.restapi.services.IRoutinesGroupService;


@Service
public class RoutinesGroupServiceImpl implements IRoutinesGroupService {

	@Autowired
	private RoutinesGroupRepository routinesGroupRepository;
	
	@Override
	public List<RoutinesGroup> findAll() {
		return routinesGroupRepository.findAll();
	}

}
