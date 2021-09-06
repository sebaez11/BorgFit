package com.routines.restapi.services.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routines.restapi.entities.Routine;
import com.routines.restapi.repositories.RoutineRepository;
import com.routines.restapi.services.IRoutineService;


/**
 *Call the RoutineRepository to execute the transactions.
 */
@Service
public class RoutineServiceImpl implements IRoutineService {

	@Autowired
	private RoutineRepository routineRepository;

	@Override
	public List<Routine> findAllByRoutinesGroupId(Short id) {
		return routineRepository.findAllByRoutinesGroupId(id);
	}

	@Override
	public Routine findRoutineById(Integer id) {
		return routineRepository.findRoutineById(id);
	}


}
