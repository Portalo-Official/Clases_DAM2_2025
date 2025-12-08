package a01_crear_hilos.tarea;

public class TareaOpcion1 implements Runnable{

	private static final String nombreClase = "TareaOpcion1";
	
	private final String nombreInstancia;

	public TareaOpcion1(String nombreInstancia) {
		super();
		this.nombreInstancia = nombreInstancia;
	}
	
	@Override
	public void run() {
		
		System.out.println("-----------------------\n"
				+ nombreClase +
				"\nNombre Hilo: "+this.nombreInstancia
				+"\n-----------------------\n");
		
	}
}
