package proxi_basico;

import proxi_basico.controller.CustomerController;
import proxi_basico.controller.EmployerController;
import proxi_basico.dao.EmployeeDAO;
import proxi_basico.service.auth.EmployeAuth;
import proxi_basico.service.employee.impl.EmployeeServiceImpl;
import proxi_basico.utils.BootSys;
import proxi_basico.utils.UsuarioSesion;

public class App {

	/*
	 * Tenemos 3 usuarios:
	 * 
	 * Rol: ADMIN
	 *    - user: admin
	 *    - pass: admin123
	 *    
	 * Rol: SALES
	 * 	  - user: sales
	 *    - pass: sales123
	 *    
	 * Rol: READONLY
	 * 	  - user: guest
	 *    - pass: guest
	 * 
	 * */
	
	public static void main(String[] args) {
		//-- Iniciar Sistema
		BootSys system = BootSys.iniciarSistema();
		
		
		//-- Simulamos que usuario accede con sus credenciales al sistema
		
		//-- Credenciales invalidas
//		initSession("User", "Pass");
//		System.out.println(system.getEmployerController().obtenerTodos());
		
		//-- Credenciales correctas con otro rol
//		initSession("sales", "sales123");
//		System.out.println(system.getEmployerController().obtenerTodos());
		
		initSession("guest", "guest");
		System.out.println(system.getEmployerController().obtenerTodos());
//		int id =2; 
//		
//		system.getEmployerController().eliminar( id );
		
		
	}

	
	private static void initSession(String user, String pass) {
		UsuarioSesion.setCredentials( user , pass);
		
	}


	
}
