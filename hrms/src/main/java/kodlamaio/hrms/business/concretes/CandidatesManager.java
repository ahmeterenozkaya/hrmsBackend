package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.dataAccess.abstracts.CandidatesDao;
import kodlamaio.hrms.entities.concretes.Candidates;

@Service
public class CandidatesManager implements CandidateService{
	
	private CandidatesDao candidatesDao;
	
	@Autowired
	public CandidatesManager(CandidatesDao candidatesDao) {
		super();
		this.candidatesDao = candidatesDao;
	}

	@Override
	public List<Candidates> getAll() {
		// TODO Auto-generated method stub
		return this.candidatesDao.findAll();
	}

}
