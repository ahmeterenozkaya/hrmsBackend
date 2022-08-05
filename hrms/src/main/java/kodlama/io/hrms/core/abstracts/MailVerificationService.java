package kodlama.io.hrms.core.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;

public interface MailVerificationService {
	Result mailVerification(String email);
}
