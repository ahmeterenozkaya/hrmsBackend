package kodlama.io.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.abstracts.MernisCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MerniceServiceAdapter implements MernisCheckService {

	@Override
	public Result checkIfRealPerson(JobSeeker jobSeeker) throws NumberFormatException, RemoteException {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentity_number()),
				jobSeeker.getFirst_name(),
				jobSeeker.getLast_name(),
				jobSeeker.getBirth_year());
		
		if(!result) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

}
