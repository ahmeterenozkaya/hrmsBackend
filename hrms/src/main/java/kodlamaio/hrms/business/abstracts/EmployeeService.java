package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Employees;

public interface EmployeeService {
	List<Employees> getAll();

}
