package com.hrms.hrms.busniess.abstracts.userService;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.users.Employers;

public interface EmployersService {
	DataResult<List<Employers>> getAll();
	Result add(Employers employers);
}
