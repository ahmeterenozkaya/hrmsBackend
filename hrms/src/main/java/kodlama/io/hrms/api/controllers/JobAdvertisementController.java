package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
//import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByOrderByApplicationDeadlineAsc")
	public DataResult<List<JobAdvertisement>> getByOrderByApplicationDeadlineAsc(){
		return this.jobAdvertisementService.getByOrderByApplicationDeadlineAsc();
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	
	@GetMapping("/getByEmployer_Company_NameAndIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyNameAndIsActiveTrue(@RequestParam String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyNameAndIsActiveTrue(companyName);
	}
	
//	@GetMapping("/getJobAdvertisementDtoWithEmployerDetails")
//	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoWithEmployerDetails(){
//		return this.jobAdvertisementService.getJobAdvertisementDtoWithEmployerDetails();
//	}
}