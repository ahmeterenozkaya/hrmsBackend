package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.busniess.abstracts.userService.SystemPersonelService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.users.SystemPersonel;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	private SystemPersonelService systemPersonelService;

	@Autowired
	public CandidatesController(SystemPersonelService systemPersonelService) {
		super();
		this.systemPersonelService = systemPersonelService;
	}
	
	@GetMapping("/getAllSystemPersonel")
	public DataResult<List<SystemPersonel>> getAllSystemPersonel(){
		return this.systemPersonelService.getAll();
	}
	
	@PostMapping("/addCandidates")
	public Result add(@RequestBody SystemPersonel systemPersonel) {
		return this.systemPersonelService.add(systemPersonel);
	}
}
