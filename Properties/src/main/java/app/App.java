package app;

import config.EnvironmentAccess;

public class App {

	public static void main(String[] args) {
		
		EnvironmentAccess env = EnvironmentAccess.getInstance();
		
		String url = env.getValue("bbdd.url");
		
		System.out.println(url);
	}
}
