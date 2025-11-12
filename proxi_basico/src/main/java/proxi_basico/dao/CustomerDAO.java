package proxi_basico.dao;

import java.sql.Connection;
import java.sql.SQLException;

import proxi_basico.connection.ConexionBaseDatos;


public class CustomerDAO {

Connection conexion;
	
	public CustomerDAO() throws SQLException {
		super();
		this.conexion = ConexionBaseDatos.getInstance().getConnection();
	}

	// Metodos como Employe
	
}
