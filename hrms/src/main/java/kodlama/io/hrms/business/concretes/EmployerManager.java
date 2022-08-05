package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.abstracts.HrConfirmationService;
import kodlama.io.hrms.core.abstracts.MailVerificationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private MailVerificationService mailVerificationService;
	private HrConfirmationService hrConfirmationService;
	private List<User> list;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, MailVerificationService mailVerificationService, HrConfirmationService hrConfirmationService, List<User> list) {
		super(); 
		this.employerDao = employerDao;
		this.mailVerificationService = mailVerificationService;
		this.hrConfirmationService = hrConfirmationService;
		this.list = list;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		if(!this.mailVerificationService.mailVerification(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Emailinizi kontrol edin");
		}
		
		if(!this.hrConfirmationService.isConfirmed(employer).isSuccess()) {
			return new ErrorResult("H.R tarafından onaylanmadı");
		}
			
		if(!this.employerCheck(employer).isSuccess()) {
			return new ErrorResult("Geçersiz bilgiler mevcut");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("Kayıt başarılı");
	}
	
	public Result employerCheck(Employer employer) {
		if(employer.getCompanyName() == null) {
			return new ErrorResult("İsim boş bırakılamaz");
		}
		else if(employer.getWeb_address() == null) {
			return new ErrorResult("Web adresi boş bırakılamaz");
		}
		else if(employer.getPhone_number() == null) {
			return new ErrorResult("Telefon numarası boş bırakılamaz");
		}
		else if(employer.getEmail() == null) {
			return new ErrorResult("Email boş bırakılamaz");
		}
		else if(employer.getPassword() == null) {
			return new ErrorResult("Parola boş bırakılamaz");
		}
		return new SuccessResult("Kayıt başarılı");
	}
	
	public boolean checkEmployerMail(String mail) {
		for(User employers:this.list) {
			if(employers.getEmail().equalsIgnoreCase(mail)) {
				return true;
			}
		}
		return false;
	}

}
