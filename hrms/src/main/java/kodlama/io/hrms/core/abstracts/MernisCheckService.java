package kodlama.io.hrms.core.abstracts;

import java.rmi.RemoteException;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface MernisCheckService {
	 Result checkIfRealPerson(JobSeeker jobSeeker) throws NumberFormatException, RemoteException;
}
