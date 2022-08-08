package com.hrms.hrms.busniess.concretes.jobServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.busniess.abstracts.jobService.JobPositionService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.jobDao.JobPositionDao;
import com.hrms.hrms.entities.concretes.jobs.JobPosition;

@Service
public class JobPositionServiceImpl implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionServiceImpl(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Data getirildi.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		jobPositionDao.save(jobPosition);
		return new SuccessResult("Data veritabanına eklendi.");
	}

}
