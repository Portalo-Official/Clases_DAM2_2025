package proxi_basico.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
	private static volatile ConexionBaseDatos INSTANCE;
	private Connection connection;

	// Config mínima (esto en un futuro lo leeremos en otro sitio)
	private static final String URL = "jdbc:mysql://localhost:3306/empleados_dam?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static final String USER = "app";
	private static final String PASS = "app123";

	// Constructor Privado para que nadie desde fuera pueda instanciar
	private ConexionBaseDatos() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ignored) {
			
		}
	}

	public static ConexionBaseDatos getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ConexionBaseDatos();
		}
		return INSTANCE;
	}

	public Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(URL, USER, PASS);
		}
		return connection;
	}
}
