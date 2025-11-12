package globales.dao;

import globales.utils.ConexionBBDD;

public class CustomerDAO {

	private String CONEXION;
	
	public CustomerDAO() {
		super();
		this.CONEXION = ConexionBBDD.CONEXION_BASE_DATOS;
	}

	public void crear() {
		String asda = this.CONEXION; // crear empleado
		
	}
	
	public void actualizar() {
		ConexionBBDD.CONEXION_BASE_DATOS = "CONEXION002321.TIMEOUT=FALSE.CUSTOMER";
	}
	
}
