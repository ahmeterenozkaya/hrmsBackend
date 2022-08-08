package com.hrms.hrms.busniess.concretes.jobServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.busniess.abstracts.jobService.CityService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.jobDao.CityDao;
import com.hrms.hrms.entities.concretes.jobs.City;
import com.hrms.hrms.entities.concretes.jobs.Jobs;

@Service
public class CityServiceImpl implements CityService {

	private CityDao cityDao;
	
	@Autowired
	public CityServiceImpl(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<City>>(cityDao.findAll(),"Data getirildi.");
	}

	@Override
	public Result add(City city) {
		cityDao.save(city);
		return new SuccessResult("Data veritabanına eklendi.");
	}

}
