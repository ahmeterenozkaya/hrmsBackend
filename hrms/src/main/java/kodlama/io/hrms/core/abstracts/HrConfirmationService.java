package kodlama.io.hrms.core.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;

public interface HrConfirmationService {
	public Result isConfirmed(Employer employer);
}
