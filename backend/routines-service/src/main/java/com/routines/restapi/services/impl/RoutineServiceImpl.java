package com.routines.restapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routines.restapi.entities.Routine;
import com.routines.restapi.repositories.RoutineRepository;
import com.routines.restapi.services.IRoutineService;

@Service
public class RoutineServiceImpl implements IRoutineService {

	@Autowired
	private RoutineRepository routineRepository;
	
	@Override
	public List<Routine> findAll() {
		return (List<Routine>) routineRepository.findAll();
	}

	@Override
	public Routine findById(Long id) {
		return routineRepository.findById(id).orElse(null);
	}

	@Override
	public Routine save(Routine routine) {
		return routineRepository.save(routine);
	}

	@Override
	public void deleteById(Long id) {
		routineRepository.deleteById(id);
	}

}
