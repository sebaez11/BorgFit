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
	
	
	/**
	 * find all routines.
	 * @return routine list.
	 */
	@Override
	public List<Routine> findAll() {
		return (List<Routine>) routineRepository.findAll();
	}

	/**
	 * find a routine by its id.
	 * @param id routine attribute.
	 * @return returns a routine found by its id
	 */
	@Override
	public Routine findById(Long id) {
		return routineRepository.findById(id).orElse(null);
	}

	/**
	 * save a routine.
	 * @param routine object to be saved.
	 * @return returns the created object.
	 */
	@Override
	public Routine save(Routine routine) {
		return routineRepository.save(routine);
	}

	/**
	 * delete a routine by its id.
	 * @param id routine attribute.
	 */
	@Override
	public void deleteById(Long id) {
		routineRepository.deleteById(id);
	}

}
