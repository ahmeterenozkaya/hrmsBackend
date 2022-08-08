package com.hrms.hrms.busniess.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employers;

public interface EmployersService {
	DataResult<List<Employers>> getAll();
	Result add(Employers employers);
}
