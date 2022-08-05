package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
//import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getByOrderByApplicationDeadlineAsc();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getByEmployer_CompanyNameAndIsActiveTrue(String companyName);
	
	//DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoWithEmployerDetails();
	
}
