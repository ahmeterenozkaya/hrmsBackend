package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.abstracts.Users;

public interface UsersDao extends JpaRepository<Users, Integer>{

	
}
