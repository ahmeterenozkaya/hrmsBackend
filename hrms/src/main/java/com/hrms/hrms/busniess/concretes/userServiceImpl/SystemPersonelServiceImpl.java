package com.hrms.hrms.busniess.concretes.userServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hrms.hrms.busniess.abstracts.userService.SystemPersonelService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.userDao.EmployersDao;
import com.hrms.hrms.dataAccess.abstracts.userDao.SystemPersonelDao;
import com.hrms.hrms.entities.concretes.users.Employers;
import com.hrms.hrms.entities.concretes.users.SystemPersonel;

@Service
public class SystemPersonelServiceImpl implements SystemPersonelService {
	private SystemPersonelDao systemPersonelDao;
	private EmployersDao employersDao;

	@Autowired
	public SystemPersonelServiceImpl(SystemPersonelDao systemPersonelDao, EmployersDao employersDao) {
		super();
		this.systemPersonelDao = systemPersonelDao;
		this.employersDao = employersDao;
	}

	@Override
	public DataResult<List<SystemPersonel>> getAll() {
		return new SuccessDataResult<List<SystemPersonel>>(this.systemPersonelDao.findAll(), "Sistem personelleri listelendi");
	}

	@Override
	public Result add(SystemPersonel systemPersonel) {
		this.systemPersonelDao.save(systemPersonel);
		return new SuccessResult("Sistem personeli kaydedildi");
	}
	
	public DataResult<List<Employers>> getNewEmployers(){
		
		// Servisten mi çekmek gerekiyor yoksa daodan mı sorulacak!!
		List<Employers> employers = employersDao.findAll();
		List<Employers> newEmployers = new ArrayList<Employers>();
		
		
		for(Employers employer : employers) {
			if(employer.getStatus()==null) {
				newEmployers.add(employer);
			}
		}
		return new SuccessDataResult<List<Employers>>(newEmployers, "Yeni işverenler getirildi.");
	}

	@Override
	public Result setStatus(int employer_id, boolean status) {
		/*List<Employers> employers = employersDao.findAll();
		
		for(Employers employer : employers) {
			if(employer.getId() == employer_id) {
				employer.setStatus(status);
				
			}
		}*/
		
		/*List<Employers> employers = employersDao.findByStatus(status); 
		
		System.out.println(employers);*/
		
		

		return null;
	}


	
	
}
