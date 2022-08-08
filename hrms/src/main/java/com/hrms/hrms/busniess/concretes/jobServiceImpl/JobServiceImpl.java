package com.hrms.hrms.busniess.concretes.jobServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrms.hrms.busniess.abstracts.jobService.JobService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.jobDao.JobDao;
import com.hrms.hrms.entities.concretes.jobs.Jobs;

@Service
public class JobServiceImpl implements JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobServiceImpl(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Jobs>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Jobs>>(jobDao.findAll(),"Data getirildi.");
	}

	@Override
	public Result add(Jobs jobs) {
		jobDao.save(jobs);
		return new SuccessResult("Data veritabanına eklendi.");
	}

	@Override
	public DataResult<List<Jobs>> getStatusTrue() {
		return new SuccessDataResult<List<Jobs>>(jobDao.getByStatus(true), "Aktif iş ilanları getirildi.");
	}

	@Override
	public DataResult<List<Jobs>> getStatusTrueSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "createDate");
		return new SuccessDataResult<List<Jobs>>(this.jobDao.getByStatus(sort, true),"İlanlar sıralı şekilde getirildi.");
	}

	@Override
	public DataResult<List<Jobs>> getAllCompanyJobs(String companyName) {
		return new SuccessDataResult<List<Jobs>>(this.jobDao.getByEmployer_CompanyName(companyName), companyName + " şirketine ait tüm işler getirildi.");
	}

	@Override
	public Result updateByStatus(int jobsId, boolean status) {
		this.jobDao.updateStatusById(status, jobsId);
		return new SuccessResult("İş durumu güncellendi");
	}

	@Override
	public DataResult<List<Jobs>> getCompanyJobs(String companyName) {
		return new SuccessDataResult<List<Jobs>>(this.jobDao.getByEmployer_CompanyNameAndStatus(companyName,true), companyName + " şirketine ait aktif işler getirildi.");
	}

}
