package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	boolean existsEmployerByTcNo(String tcNo);

	boolean existsEmployerByEmail(String email);
	
}
