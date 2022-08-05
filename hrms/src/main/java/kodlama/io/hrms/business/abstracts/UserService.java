package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.User;

public interface UserService {
	Result add(User user);
	Result delete(User user);
	DataResult<List<User>> getAll();
	User getById(int id);
}