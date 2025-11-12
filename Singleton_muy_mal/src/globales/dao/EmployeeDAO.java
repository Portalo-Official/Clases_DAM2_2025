package globales.dao;

import globales.utils.ConexionBBDD;

public class EmployeeDAO {
	
	private ConexionBBDD conexion;
	
	public EmployeeDAO() {
		super();
	}

	public void crear() {
		String conexion = ConexionBBDD.CONEXION_BASE_DATOS;
	}
	
	public void actualizar() {
		//logica
		// mucha mas logica
		
		ConexionBBDD.CONEXION_BASE_DATOS = "CONEXION002321.TIMEOUT=FALSE.EMPLOYER.DEV";
	}
}
