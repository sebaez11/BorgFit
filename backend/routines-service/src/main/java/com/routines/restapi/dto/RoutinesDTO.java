package com.routines.restapi.dto;


public class RoutinesDTO {
	private Integer id;
	private Short level;
	private RoutinesGroupDTO routinesGroup;

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


}
