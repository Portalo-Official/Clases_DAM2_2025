package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.EnvironmentAccess;

public class ConexionBBDD {
	private static ConexionBBDD INSTANCE;
	
	private Connection connection;

	// Constructor Privado para que nadie desde fuera pueda instanciar
	private ConexionBBDD() {

		EnvironmentAccess env = EnvironmentAccess.getInstance();
		String url = env.getRequired("bbdd.url");
		String user = env.getRequired("bbdd.username");
		String pass = env.getRequired("bbdd.pass");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException ignored) {
			
		}
		
		try {
			
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(url, user, pass);
			}
		}catch (SQLException e) {
			System.err.println("Algo ha ocurrido con la conexion a Base de datos");
		}
		
	}

	public static ConexionBBDD getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ConexionBBDD();
		}
		return INSTANCE;
	}

	public Connection getConnection() throws SQLException {
		
		return connection;
	}
}
