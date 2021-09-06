package com.routines.restapi.models;

import java.util.List;

import com.commons.entities.service.entities.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.routines.restapi.dto.RoutineDTO;
import com.routines.restapi.dto.RoutinesDTO;
import com.routines.restapi.dto.RoutinesGroupDTO;
import com.routines.restapi.dto.WorkoutDTO;

@JsonInclude(Include.NON_NULL)
public class RoutineResponse {

	private Status status;
	private List<RoutinesGroupDTO> routinesGroup;
	private List<RoutinesDTO> routines;
	private RoutineDTO routine;

	public RoutineResponse() {
		this.status = new Status();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<RoutinesGroupDTO> getRoutinesGroup() {
		return routinesGroup;
	}

	public void setRoutinesGroup(List<RoutinesGroupDTO> routinesGroup) {
		this.routinesGroup = routinesGroup;
	}

	public List<RoutinesDTO> getRoutines() {
		return routines;
	}

	public void setRoutines(List<RoutinesDTO> routines) {
		this.routines = routines;
	}

	public RoutineDTO getRoutine() {
		return routine;
	}

	public void setRoutine(RoutineDTO routine) {
		this.routine = routine;
	}

}
