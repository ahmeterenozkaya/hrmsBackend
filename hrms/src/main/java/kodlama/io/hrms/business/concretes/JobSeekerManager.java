package kodlama.io.hrms.business.concretes;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.abstracts.MailVerificationService;
import kodlama.io.hrms.core.abstracts.MernisCheckService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private MernisCheckService mernisCheckService;
	private MailVerificationService mailVerificationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService, MailVerificationService mailVerificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisCheckService = mernisCheckService;
		this.mailVerificationService = mailVerificationService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"İş arayan listelendi");
	}

	@Override
	public Result addJobSeeker(JobSeeker jobSeeker) throws NumberFormatException, RemoteException {
		Result checkPerson = mernisCheckService.checkIfRealPerson(jobSeeker);
		
		if(!checkPerson.isSuccess()) {
			return new ErrorResult("Kişi bulunamadı");
		}
		
		if(!this.jobSeekerCheck(jobSeeker).isSuccess()) {
			return new ErrorResult("Geçersiz bilgiler mevcut");
		}
		
		if(!this.mailVerificationService.mailVerification(jobSeeker.getEmail()).isSuccess()){
			return new ErrorResult("Email adresinizi kontrol edin");
		}
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Kayıt başarılı");
	}
	
	public Result jobSeekerCheck(JobSeeker jobSeeker) {
		if(jobSeeker.getFirst_name()==null) {
			return new ErrorResult("İsim boş bırakılamaz");
		}
		else if(jobSeeker.getLast_name()==null) {
			return new ErrorResult("Soyisim boş bırakılamaz");
		}
		else if(jobSeeker.getIdentity_number()==null) {
			return new ErrorResult("T.C numarası boş bırakılamaz");
		}
		else if(jobSeeker.getBirth_year()<1900 || jobSeeker.getBirth_year()>LocalDate.now().getYear()) {
			return new ErrorResult("Doğum yılı boş bırakılamaz");
		}
		else if(jobSeeker.getPassword()==null) {
			return new ErrorResult("Şifre boş bırakılamaz");
		}
		else if (jobSeeker.getEmail()==null) {
			return new ErrorResult("Email boş bırakılamaz.");
		}
		return new SuccessResult("Kayıt başarılı");
	}

}
