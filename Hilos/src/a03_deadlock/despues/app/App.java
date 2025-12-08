package a03_deadlock.despues.app;

import a03_deadlock.despues.hilo.consumidorServicionDos;
import a03_deadlock.despues.hilo.consumidorServicionUno;
import a03_deadlock.despues.recurso.RecursoA;
import a03_deadlock.despues.recurso.RecursoB;

public class App {

	
	 public static void main(String[] args) {

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
