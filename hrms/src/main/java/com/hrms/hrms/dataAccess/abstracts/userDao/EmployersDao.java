package com.hrms.hrms.dataAccess.abstracts.userDao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.users.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{
	boolean existsEmployerByEmail(String email);
}
