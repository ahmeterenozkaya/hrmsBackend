package com.hrms.hrms.dataAccess.abstracts.jobDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hrms.hrms.entities.concretes.jobs.Jobs;

public interface JobDao extends JpaRepository<Jobs, Integer> {
	List<Jobs> getByStatus(boolean status);
	List<Jobs> getByStatus(Sort sort,boolean status);
	List<Jobs> getByEmployer_CompanyName(String companyName);
	List<Jobs> getByEmployer_CompanyNameAndStatus(String companyName,boolean status);
	
	@Transactional
    @Modifying
	@Query("Update Jobs set status=:status where id=:id")
	void updateStatusById(@Param("status") boolean status,@Param("id") int id); 
}
