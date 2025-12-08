package a01_crear_hilos.app;

import a01_crear_hilos.tarea.TareaOpcion1;
import a01_crear_hilos.tarea.TareaOpcion2;

public class App02 {

	public static void main(String[] args) {
		
		TareaOpcion1 task1= new TareaOpcion1("Hilo 1");

		TareaOpcion2 task2= new TareaOpcion2("Hilo 2");
		
		/**
		 * Aunque task2 se puede invocar directamente el método .start()
		 * 
		 * Aqui la cuestión es que un sistema trrabajará con varios hilos, y cada
		 * uno tendra una implementación distinta. 
		 * 
		 * Por lo tanto tenemos que movernos a traves de la abstracción y trabajar con 
		 * la clase thread. 
		 * 
		 */
		
		// Constructor -> new Thread(Runnable target)
		Thread hiloTask1 = new Thread(task1);
		Thread hiloTask2 = new Thread(task2);
		
		hiloTask1.start();
		hiloTask2.start();
		
	}
	
	
	

}
