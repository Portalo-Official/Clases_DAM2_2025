package a01_crear_hilos.tarea;

public class TareaOpcion2 extends Thread{

	private static final String nombreClase = "TareaOpcion2";
	
	private final String nombreInstancia;

	public TareaOpcion2(String nombreInstancia) {
		super();
		this.nombreInstancia = nombreInstancia;
	}
	
	// Heredada de Thread (por que implementa Runnable)
	@Override
	public void run() {
		
		System.out.println("-----------------------\n"
						+ nombreClase +
						"\nNombre Hilo: "+this.nombreInstancia
						+"\n-----------------------\n");
		
	}
	
	
}
