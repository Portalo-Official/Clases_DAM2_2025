package proxi_basico.service.auth;

import java.util.List;

import proxi_basico.model.Credentials;
import proxi_basico.model.Employee;
import proxi_basico.model.Role;
import proxi_basico.service.employee.EmployeeService;
import proxi_basico.utils.UsuarioSesion;

public class EmployeAuth implements EmployeeService{

	private final EmployeeService target;

	public EmployeAuth(EmployeeService target){
		this.target=target;
		
		}

	public Role check(String action) {
		
		Credentials cred = UsuarioSesion.GetCredentials();
		
		if ("admin".equalsIgnoreCase(cred.getUsername()) && "admin123".equals(cred.getPassword()))
			return Role.ADMIN;
		if ("sales".equalsIgnoreCase(cred.getUsername()) && "sales123".equals(cred.getPassword()))
			return Role.SALES;
		if ("guest".equalsIgnoreCase(cred.getUsername()) && "guest".equals(cred.getPassword()))
			return Role.READONLY;
		throw new SecurityException("Credenciales inválidas");
	}

	public void authorize(Role r, String action) {
		switch (r) {
		case ADMIN:
			return; // todo permitido
		case SALES:
			if ("findAll".equalsIgnoreCase(action) || "findById".equals(action) || "create".equals(action))
			return;
			throw new SecurityException("SALES no puede: " + action + " de empleados");
		case READONLY:
			if ("findAll".equalsIgnoreCase(action) || "findById".equals(action))
			return;
			throw new SecurityException("READONLY no puede: " + action + " de empleados");
		}
	}

	public List<Employee> findAll(){
		Role r = check("findAll");
		authorize(r, "findAll");
		return target.findAll();
	}

	public Employee findById(int id){
		Role r = check("findById");
		authorize(r, "findById");
		return target.findById(id);
	}

	public Employee create(Employee e){
		Role r = check("create");
		authorize(r, "create");
		Employee resultado =  target.create(e);
		return null;
	}

	public boolean update(Employee e){
		Role r = check("update");
		authorize(r, "update");
		return target.update(e);
	}

	public boolean delete(int id){
		Role r = check("delete");
		authorize(r, "delete");
		return target.delete(id);
	}
}
