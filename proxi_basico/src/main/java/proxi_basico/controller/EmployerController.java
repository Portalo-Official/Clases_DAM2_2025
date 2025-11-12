package proxi_basico.controller;

import java.util.List;

import proxi_basico.model.Employee;
import proxi_basico.service.employee.EmployeeService;

public class EmployerController{

	private final EmployeeService employeService; // apunta al PROXY

	public EmployerController(EmployeeService employeService){
		this.employeService = employeService;
	}


	public List<Employee> obtenerTodos()  {
		return employeService.findAll();
	}


	public Employee buscarPorID(int id)  {
		return this.employeService.findById(id);
	}


	public Employee crear(Employee employee){
		return this.employeService.create(employee);
	}


	public boolean actualizar(Employee employee)  {
		return this.employeService.update(employee);
	}


	public boolean eliminar(int id) {
		return this.employeService.delete(id);
	}

}
