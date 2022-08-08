package com.hrms.hrms.busniess.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.busniess.abstracts.EmployeeService;

import com.hrms.hrms.core.mernis.MernisControl;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;

import com.hrms.hrms.dataAccess.abstracts.EmployeeDao;
import com.hrms.hrms.entities.concretes.Employee;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.core.verifications.abstracts.EmailVerificationService;
import com.hrms.hrms.core.verifications.concretes.EmailVerificationServiceImpl;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	
	@Autowired(required = false)
	private MernisControl mernisControl;
	
	private EmailVerificationService emailVerificationService = new EmailVerificationServiceImpl();

	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
	
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Data listelendi");
	}
	
	private boolean mernis(Employee employee) {
		try {
			if(!mernisControl.checkMernis(Long.valueOf( employee.getTcNo() ) , employee.getName() , employee.getSurname() , employee.getBirthOfYear())) {
				return false;
			}
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Result add(Employee employee){
		
		if(checkNull(employee)) {
			return new ErrorResult("Tüm Alanlar Zorunludur.");
		}
		/*else if(mernis(employee)) {
			return new ErrorResult("Kişi bilgileri doğru değil");
		}*/
		else if(this.employeeDao.existsEmployerByTcNo(employee.getTcNo())) {
			return new ErrorResult("Tc Kimlik No Sisteme Kayıtlı.");
		}
		else if(this.employeeDao.existsEmployerByEmail(employee.getEmail())) {
			return new ErrorResult("Email Sisteme Kayıtlı.");
		}
		else if(this.emailVerificationService.isVerified(employee.getEmail())) {
			return new ErrorResult("Mail Doğrulaması Yapılamadı.");
		}
		else {
			this.employeeDao.save(employee);
			return new SuccessResult("Kişi eklendi"); 
		}
	}
	private boolean checkNull(Employee employee) {
		if( employee.getEmail()==null || employee.getName()==null || employee.getPass() == null || 
				employee.getPassAgain() == null || employee.getTcNo()==null || employee.getBirthOfYear()==0 ) {
			return true;
		}
		return false;
	}
}
