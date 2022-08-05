package kodlama.io.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.abstracts.HrConfirmationService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class HrConfirmationManager implements HrConfirmationService {

	@Override
	public Result isConfirmed(Employer employer) {
		return new SuccessResult("Onaylandı");
	}

}
