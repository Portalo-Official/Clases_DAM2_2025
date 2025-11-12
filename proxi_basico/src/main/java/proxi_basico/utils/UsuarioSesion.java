package proxi_basico.utils;

import proxi_basico.model.Credentials;

public class UsuarioSesion {

	private static Credentials cred;
	
	public static Credentials GetCredentials() {
		return cred;
	};
	
	public static void setCredentials(String user, String pass) {
		cred = new Credentials(user, pass);
	}
	
}
