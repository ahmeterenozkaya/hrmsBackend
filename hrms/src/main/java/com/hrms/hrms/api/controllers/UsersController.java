package com.hrms.hrms.api.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.busniess.abstracts.userService.EmployeeService;
import com.hrms.hrms.busniess.abstracts.userService.EmployersService;
import com.hrms.hrms.busniess.abstracts.userService.SystemPersonelService;
import com.hrms.hrms.busniess.abstracts.userService.UsersService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.abstracts.Users;
import com.hrms.hrms.entities.concretes.users.Employee;
import com.hrms.hrms.entities.concretes.users.Employers;
import com.hrms.hrms.entities.concretes.users.SystemPersonel;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UsersService usersService;

	@Autowired
	public UsersController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Users>> getAll(){
		return this.usersService.getAll();
	}	
}
