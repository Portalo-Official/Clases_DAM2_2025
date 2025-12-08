package a01_crear_hilos.app;

import a01_crear_hilos.tarea.TareaOpcion1;
import a01_crear_hilos.tarea.TareaOpcion2;

public class App01 {

	public static void main(String[] args) {
		
		TareaOpcion1 task1= new TareaOpcion1("Hilo 1");

		TareaOpcion2 task2= new TareaOpcion2("Hilo 2");
		
		/**
		 * Un hilo tiene un ciclo de vida: Preparado, Ejecutandose y Acabado
		 * 
		 * - Cuando se instancia esta preparado.
		 * - Para ejecutarse tiene que llamarse al metodo .start()
		 * 		- El metodo start() invoca al método .run()
		 * - Una vez finalizada la tarea (metodo run) el hilo ha acabado  	
		 */
		
		task2.start();
//		No tiene .start
//		task1.start();

	}
	
	
	

}
