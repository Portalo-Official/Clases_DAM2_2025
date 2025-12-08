package a03_deadlock.antes.app;

import a03_deadlock.antes.hilo.consumidorServicionDos;
import a03_deadlock.antes.hilo.consumidorServicionUno;
import a03_deadlock.antes.recurso.RecursoA;
import a03_deadlock.antes.recurso.RecursoB;

public class App {

	 public static void main(String[] args) {

	        // Creamos dos recursos compartidos
	        RecursoA recursoA = new RecursoA("RECURSO_A");
	        RecursoB recursoB = new RecursoB("RECURSO_B");

	        
	        Thread hilo1 = new Thread(
	                new consumidorServicionUno(recursoA, recursoB),
	                "Hilo-A"
	        );

	        
	        Thread hilo2 = new Thread(
	                new consumidorServicionDos(recursoB, recursoA),
	                "Hilo-B"
	        );

	        hilo1.start();
	        hilo2.start();
	    }
}
