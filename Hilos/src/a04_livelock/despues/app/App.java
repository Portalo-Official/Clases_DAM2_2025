package a04_livelock.despues.app;

import a04_livelock.despues.hilo.Trabajador;
import a04_livelock.despues.recurso.Recurso;

public class App {

	/**
	 * - Los hilos siguen ejecutándose (no están bloqueados).
	 * - Reaccionan continuamente al estado del sistema.
	 * - Pero no progresan nunca.
	 * 
	 * Problema: Los hilos tienen una politica demasiado educada
	 */
	
	 public static void main(String[] args) {
	        Recurso recursoA = new Recurso("Recurso-A");
	        Recurso recursoB = new Recurso("Recurso-B");

	        // Trabajador-1: intenta primero A y luego B
	        Trabajador t1 = new Trabajador("Trabajador-1", recursoA, recursoB);

	        // Trabajador-2: intenta primero B y luego A
	        Trabajador t2 = new Trabajador("Trabajador-2", recursoB, recursoA);

	        Thread hilo1 = new Thread(t1);
	        Thread hilo2 = new Thread(t2);

	        hilo1.start();
	        hilo2.start();
	    }
	
}
