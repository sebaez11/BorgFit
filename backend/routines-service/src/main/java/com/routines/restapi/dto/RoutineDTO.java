package com.routines.restapi.dto;

import java.util.List;

public class RoutineDTO {

	private Integer id;
	private Short level;
	private RoutinesGroupDTO routinesGroup;
	private List<WorkoutDTO> workouts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getLevel() {
		return level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public RoutinesGroupDTO getRoutinesGroup() {
		return routinesGroup;
	}

	public void setRoutinesGroup(RoutinesGroupDTO routinesGroup) {
		this.routinesGroup = routinesGroup;
	}

	public List<WorkoutDTO> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<WorkoutDTO> workouts) {
		this.workouts = workouts;
	}

}
