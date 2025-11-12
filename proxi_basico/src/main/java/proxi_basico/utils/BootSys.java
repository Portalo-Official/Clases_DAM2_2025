package proxi_basico.utils;

import proxi_basico.controller.CustomerController;
import proxi_basico.controller.EmployerController;
import proxi_basico.dao.EmployeeDAO;
import proxi_basico.service.auth.EmployeAuth;
import proxi_basico.service.employee.EmployeeService;
import proxi_basico.service.employee.impl.EmployeeServiceImpl;
// Esta clase es un ejemplo malo para quitarle peso al main en la explicación.
public class BootSys {

	private EmployerController employerController = null;
	private CustomerController customerController = null;

	
	private BootSys() {
		super();
		inyectarDependencias();
	}

	private void inyectarDependencias() {
		
		EmployeeService serviceREAL = new EmployeeServiceImpl(new EmployeeDAO());
		
		EmployeeService employeProxy = new EmployeAuth( serviceREAL);
		
		this.employerController = new EmployerController(employeProxy);
		
		//this.customerController = .... inyecciones
	}
	
	public static BootSys iniciarSistema() {
		BootSys system= new BootSys();
		
		return system;
	}

	public EmployerController getEmployerController() {
		return employerController;
	}

	public CustomerController getCustomerController() {
		return customerController;
	}
}
