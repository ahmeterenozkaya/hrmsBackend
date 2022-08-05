package kodlama.io.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.abstracts.MailVerificationService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

@Service
public class MailVerificationManager implements MailVerificationService {

	@Override
	public Result mailVerification(String email) {
		return new SuccessResult("Email doğrulandı");
	}

}
