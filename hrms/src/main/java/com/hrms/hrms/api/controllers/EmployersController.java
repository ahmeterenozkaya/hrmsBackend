package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.busniess.abstracts.userService.EmployersService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.users.Employers;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	private EmployersService employerService;

	@Autowired
	public EmployersController(EmployersService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getAllEmployers")
	public DataResult<List<Employers>> getAllEmployers(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/addEmployer")
	public Result add(@RequestBody Employers employers) {
		return this.employerService.add(employers);
	}
}
