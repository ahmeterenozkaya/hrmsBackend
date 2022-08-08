package com.hrms.hrms.dataAccess.abstracts.jobDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.jobs.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
