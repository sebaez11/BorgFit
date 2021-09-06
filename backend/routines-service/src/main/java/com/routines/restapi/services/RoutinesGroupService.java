package com.routines.restapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.routines.restapi.dto.RoutinesGroupDTO;
import com.routines.restapi.entities.RoutinesGroup;
import com.routines.restapi.models.RoutineResponse;
import com.routines.restapi.utils.UtilsMethods;


@Service
public class RoutinesGroupService {

	@Autowired
	private IRoutinesGroupService iRoutinesGroupService;
	
	@Autowired
	private UtilsMethods utilMethods;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<RoutineResponse> findAll(){
		RoutineResponse routineResponse = new RoutineResponse();
		
		try {
			List<RoutinesGroup> routinesGroups = iRoutinesGroupService.findAll();
			List<RoutinesGroupDTO> routinesGroupDTO = routinesGroups.stream()
														.map(routinesGroup -> modelMapper.map(routinesGroup, RoutinesGroupDTO.class))
														.collect(Collectors.toList());
			routineResponse.setRoutinesGroup(routinesGroupDTO);
			utilMethods.responseOk(routineResponse);
		} catch (Exception e) {
			utilMethods.responseInternalServerError(routineResponse);
		}
		
		return utilMethods.response(routineResponse);
	}
	
}
