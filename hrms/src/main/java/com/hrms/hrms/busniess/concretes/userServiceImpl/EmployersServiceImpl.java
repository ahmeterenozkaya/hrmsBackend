package com.hrms.hrms.busniess.concretes.userServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.busniess.abstracts.userService.EmployersService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.core.verifications.abstracts.EmailVerificationService;
import com.hrms.hrms.dataAccess.abstracts.userDao.EmployerStatusDao;
import com.hrms.hrms.dataAccess.abstracts.userDao.EmployersDao;
import com.hrms.hrms.entities.concretes.users.Employers;

@Service
public class EmployersServiceImpl implements EmployersService{
	private EmployersDao employersDao;

	@Autowired
	public EmployersServiceImpl(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	}
	
	@Autowired(required = false)
	private EmailVerificationService emailVerificationService;

	@Override
	public DataResult<List<Employers>> getAll() {
		return new SuccessDataResult<List<Employers>>(this.employersDao.findAll(),"İş verenler listelendi");
	}

	@Override
	public Result add(Employers employers) {
		if(checkNull(employers)) {
			return new ErrorResult("Tüm Alanlar Zorunludur.");
		}
		else if(!employers.getPass().equals(employers.getPassAgain())) {
			return new ErrorResult("Şifre ve Şifre Tekrarı Aynı Değil.");
		}
		/*else if(!emailVerificationService.isVerified( employers.getEmail() )) {
			return new ErrorResult("Email Onaylanmadı.");
		}*/
		else if(checkSameDomain(employers.getEmail(), employers.getWebSite())) {
			return new ErrorResult("Email Website ile Aynı Domaine Sahip Değil.");
		}
		else if(employersDao.existsEmployerByEmail(employers.getEmail())) {
			return new ErrorResult("Email Adresi Başka Birisi Tarafından Kullanılıyor.");
		}
		else {
			employers.setStatus(null);
			this.employersDao.save(employers);
			return new SuccessResult("İşveren sisteme eklendi onay bekleniyor.");
		}
	}
	private boolean checkNull(Employers employers) {
		if(employers.getCompanyName()== null || employers.getWebSite()==null || employers.getPass()==null || employers.getPassAgain()==null || employers.getEmail()==null || employers.getPhoneNumber() == null ) {
			return true;
		}
		return false;
	}
	
	private boolean checkSameDomain(String email, String website) {
		int index = email.indexOf("@");
		String emailDomain = email.substring(index);
		String webSiteDomain = website.replaceFirst("^(https?://)?(www\\\\.)?", "");
		if(emailDomain.contains(webSiteDomain)) {
			return true;
		}
		return false;
	}
	
}