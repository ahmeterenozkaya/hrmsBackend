package com.hrms.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{
	boolean existsEmployerByEmail(String email);
}
