package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.busniess.abstracts.jobService.JobService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.jobs.Jobs;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(name="/api/jobs")
public class JobsController {
	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Jobs>> getAll(){
		return jobService.getAll();
	}
	
	@GetMapping("/getStatusTrue")
	public DataResult<List<Jobs>> getStatusTrue(){
		return jobService.getStatusTrue();
	}
	
	@GetMapping("/getStatusTrueSorted")
	public DataResult<List<Jobs>> getStatusTrueSorted(){
		return jobService.getStatusTrueSorted();
	}
	
	@GetMapping("/getAllCompanyJobs")
	public DataResult<List<Jobs>> getAllCompanyJobs(@RequestBody String companyName){
		return jobService.getAllCompanyJobs(companyName);
	}
	
	@GetMapping("/getCompanyJobs")
	public DataResult<List<Jobs>> getCompanyJobs(@RequestBody String companyName){
		return jobService.getCompanyJobs(companyName);
	}
	
	@PostMapping("/updateByStatus")
	public Result updateByStatus(@RequestParam("jobsId") int jobsId, @RequestParam("status") boolean status){
		return jobService.updateByStatus(jobsId, status);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Jobs jobs) {
		return jobService.add(jobs);
	}
	

}
