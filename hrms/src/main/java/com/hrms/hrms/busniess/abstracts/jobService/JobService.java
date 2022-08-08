package com.hrms.hrms.busniess.abstracts.jobService;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.jobs.Jobs;

public interface JobService {
	DataResult<List<Jobs>> getAll();
	Result add(Jobs jobs);
	DataResult<List<Jobs>> getStatusTrue();
	DataResult<List<Jobs>> getStatusTrueSorted();
	DataResult<List<Jobs>> getAllCompanyJobs(String companyName);
	DataResult<List<Jobs>> getCompanyJobs(String companyName);
	Result updateByStatus(int jobsId, boolean status);
}
