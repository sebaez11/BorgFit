package com.routines.restapi.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routines.restapi.repositories.RoutineRepository;
import com.routines.restapi.services.IRoutineService;


/**
 *Call the RoutineRepository to execute the transactions.
 */
@Service
public class RoutineServiceImpl implements IRoutineService {

	@Autowired
	private RoutineRepository routineRepository;
	
}
