package com.hrms.hrms.dataAccess.abstracts.userDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.users.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	boolean existsEmployerByTcNo(String tcNo);

	boolean existsEmployerByEmail(String email);
	
}
