package singleton;

public class Singleton {
	//Evita que se manipule desde fuera
	private static Singleton INSTANCIA;
	
	// Evita que uses new -> crear nueva instancia
	private Singleton() {
		//Cosas logicas que hara la clase para inicializar
	}
	
	//Encargado de crear una unica instancia
	public static Singleton getInstancia() {
		if (INSTANCIA == null) {
			System.out.println("Creando instancia nueva");
			INSTANCIA = new Singleton();
		}
		return INSTANCIA;
	}
	
	public String metodo1(String cadena) {
		return "[LOGICA]"+cadena;
	}
	
}
