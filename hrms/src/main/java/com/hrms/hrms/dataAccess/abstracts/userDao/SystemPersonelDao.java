package com.hrms.hrms.dataAccess.abstracts.userDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.users.SystemPersonel;

public interface SystemPersonelDao extends JpaRepository<SystemPersonel, Integer>{

	
	
}
