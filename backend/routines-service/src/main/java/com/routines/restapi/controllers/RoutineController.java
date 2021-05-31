package com.routines.restapi.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.routines.restapi.services.IRoutineService;


/**
 *controls the routine requests.
 */
@RestController
public class RoutineController {

	@Autowired
	private IRoutineService iRoutineService;

	
}
