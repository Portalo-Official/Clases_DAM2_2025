package a04_livelock.despues.hilo;

import a04_livelock.despues.recurso.Recurso;
import util.ConsoleDebug;

public class Trabajador implements Runnable {

	 private final String nombre;
	    private Recurso recursoA;
	    private Recurso recursoB;
	    private int trabajoReal = 0;

	    public Trabajador(String nombre, Recurso recursoA, Recurso recursoB) {
	        this.nombre = nombre;
	        this.recursoA = recursoA;
	        this.recursoB = recursoB;
	    }

	    @Override
	    public void run() {
	    	
	        while (true) {

	            // Intento asegurar que tengo el recurso actual
	            if (!recursoA.intentarOcupar(nombre, this)) {
	                dormir(10);
	                continue;
	            }
	            
	            recursoA.darPaso(true);
	            
	            // Pregunto al recursoB
	            if (recursoB.estaDandoPaso()) {
	                
	            	// Si el otro recurso está libre, suelto el mío y cambio de idea:
	            	ConsoleDebug.log(nombre, " ve que " + recursoB.getNombre()
	                        + " está LIBRE, así que cede " + recursoA.getNombre()
	                        + " y cambia su preferencia.");

	                recursoA.liberar(nombre, this);

	                // Intercambio roles: ahora quiero el otro recurso
	                Recurso tmp = recursoA;
	                recursoA = recursoB;
	                recursoB = tmp;

	                // Vuelta a empezar, sin hacer trabajoReal++
	                dormir(10);
	                continue;
	            }

	            // Solo llego aquí si el otro recurso NO está libre.
	            // Este sería el "trabajo útil" (progreso real).
	            trabajoReal++;
	            ConsoleDebug.log(nombre, " TRABAJA de verdad en " + recursoA.getNombre()
	                    + " (trabajoReal=" + trabajoReal + ")");
	            // Si quieres, podrías terminar cuando hayas hecho X unidades de trabajo.
	            if (trabajoReal >= 3) {
	                System.out.println(nombre + " ha terminado su trabajo. Fin del hilo.");
	                recursoA.liberar(nombre, this);
	                break;
	            }

	            dormir(10);
	        }
	    }

	    private void dormir(long millis) {
	        try {
	            Thread.sleep(millis);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
}
