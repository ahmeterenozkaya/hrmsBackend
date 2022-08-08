package com.hrms.hrms.busniess.abstracts.userService;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.abstracts.Users;

public interface UsersService {
	DataResult<List<Users>> getAll();
	Result add(Users users);
}
