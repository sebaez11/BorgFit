package com.routines.restapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RoutineWorkoutPK implements Serializable {

	@Column(name = "routine_id")
	private Long routineId;
	
	@Column(name = "workout_id")
	private Long workoutId;

	public Long getRoutineId() {
		return routineId;
	}

	public void setRoutineId(Long routineId) {
		this.routineId = routineId;
	}

	public Long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Long workoutId) {
		this.workoutId = workoutId;
	}


	
	
	
}
