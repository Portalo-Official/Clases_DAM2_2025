package proxi_basico.service.employee;

import java.util.List;

import proxi_basico.model.Employee;

public interface EmployeeService {
	List<Employee> findAll() ;
	Employee findById(int id);
	Employee create(Employee employee);
	boolean update(Employee employee);
	boolean delete(int id);
}
