package com.routines.restapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.routines.restapi.dto.RoutineDTO;
import com.routines.restapi.dto.RoutinesDTO;
import com.routines.restapi.entities.Routine;
import com.routines.restapi.models.RoutineResponse;
import com.routines.restapi.utils.UtilsMethods;

@Service
public class RoutineService {

	@Autowired
	private IRoutineService iRoutineService;
	
	@Autowired
	private UtilsMethods utilsMethods;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<RoutineResponse> findAllByRoutinesGroupId(Short id){
		RoutineResponse routineResponse = new RoutineResponse();
		try {
			List<Routine> routines = iRoutineService.findAllByRoutinesGroupId(id);
			List<RoutinesDTO> routinesDTO = routines.stream()
														.map(routine -> modelMapper.map(routine, RoutinesDTO.class))
														.collect(Collectors.toList());
			routineResponse.setRoutines(routinesDTO);
			utilsMethods.responseOk(routineResponse);
		} catch (Exception e) {
			utilsMethods.responseInternalServerError(routineResponse);
		}
		
		return utilsMethods.response(routineResponse);
	}
	
	public ResponseEntity<RoutineResponse> findById(Integer id){
		RoutineResponse routineResponse = new RoutineResponse();
		try {
			Routine routine = iRoutineService.findRoutineById(id);
			RoutineDTO routineDTO = modelMapper.map(routine, RoutineDTO.class);
			routineResponse.setRoutine(routineDTO);
			utilsMethods.responseOk(routineResponse);
			
		} catch (Exception e) {
			utilsMethods.responseInternalServerError(routineResponse);
		}
		
		
		return utilsMethods.response(routineResponse);
	}
	
	
}
