package com.hrms.hrms.busniess.abstracts.jobService;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.jobs.City;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
}
