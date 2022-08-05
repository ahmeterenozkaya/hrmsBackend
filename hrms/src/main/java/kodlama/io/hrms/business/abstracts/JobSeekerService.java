package kodlama.io.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	
	Result addJobSeeker(JobSeeker jobSeeker) throws NumberFormatException, RemoteException;
} 
