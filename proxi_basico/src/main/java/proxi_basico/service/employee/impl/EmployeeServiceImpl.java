package proxi_basico.service.employee.impl;

import java.util.List;

import proxi_basico.dao.EmployeeDAO;
import proxi_basico.model.Employee;
import proxi_basico.service.employee.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();

	public EmployeeServiceImpl(EmployeeDAO dao) {
		super();
		this.dao = dao;
	}

	public List<Employee> findAll(){
		return dao.findAll();
	}

	public Employee findById(int id){
		return dao.findById(id);
	}

	public Employee create(Employee e){
		return dao.create(e);
	}

	public boolean update(Employee e){
		return dao.update(e);
	}

	public boolean delete(int id){
		return dao.delete(id);
	}
	
	public boolean deleteDefinitivo(int id){
		return dao.delete(id);
	}
}
