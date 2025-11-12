package proxi_basico.model;

public class Credentials {
	
	private final String username;
	private final String password;

	public Credentials(String u, String p){this.username=u; this.password=p;}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}