package singleton_basico.dao;

import java.sql.Connection;
import java.sql.SQLException;

import singleton_basico.connection.ConexionBaseDatos;

public class Customer {

	private Connection conexion;
	
	public Customer() throws SQLException {
		super();
		this.conexion = ConexionBaseDatos.getInstance().getConnection();
	}

	// Metodos como Employe
	
}
