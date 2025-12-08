package a04_livelock.antes.hilo;

import a04_livelock.antes.recurso.Recurso;
import util.ConsoleDebug;

public class Trabajador implements Runnable {

	 private final String nombre;
	    private Recurso recursoA;
	    private Recurso recursoB;
//	    private 

	    public Trabajador(String nombre, Recurso recursoA, Recurso recursoB) {
	        this.nombre = nombre;
	        this.recursoA = recursoA;
	        this.recursoB = recursoB;
	    }

	    @Override
	    public void run() {
	    	boolean tareaAcabada = false;
	    	boolean trabajandoEnRecursoA = recursoA.intentarOcupar(nombre, this);
	    	boolean isDoneTaskA = false;
	    	boolean isDoneTaskB = false;
	    	
	    	do {
	    		if(trabajandoEnRecursoA && !isDoneTaskA) {
	    			ConsoleDebug.log(nombre, " hago cosas en " + recursoA.getNombre());
	    			dormir(500);// Simula que hace cosas
	    			isDoneTaskA= true;
	    		}
	    		
	    		ConsoleDebug.log(nombre, " Pregunto educadamente sobre" + recursoB.getNombre());
	    		
	    		if(recursoB.estaLibre()) {
	    			
	    			recursoA.liberar(nombre, this);
	    			ConsoleDebug.log(nombre, " Libero " + recursoA.getNombre());
	    			
	    			recursoB.intentarOcupar(nombre, this);
	    			
	    			
	    			ConsoleDebug.log(nombre, " Ocupo " + recursoB.getNombre());
	    			ConsoleDebug.log(nombre, " Hago cosas en " + recursoB.getNombre());
	    			dormir(45); //Simula que hace cosas
	    			isDoneTaskB= true;
	    		}
	    		
	    		dormir(200);
	    	}while(!tareaAcabada);
	    	
	    	recursoB.liberar(nombre, this);
	    	
//	        while (!tareaAcabada) {
//
//	            // Intento asegurar que tengo el recurso actual
//	            if (!recursoA.intentarOcupar(nombre, this)) {
//	                dormir(10);
//	                continue;
//	            }
//
//	            // Pregunto al recursoB
//	            if (recursoB.estaLibre()) {
//	                
//	            	// Si el otro recurso está libre, suelto el mío y cambio de idea:
//	            	ConsoleDebug.log(nombre, " ve que " + recursoB.getNombre()
//	                        + " está LIBRE, así que cede " + recursoA.getNombre()
//	                        + " y cambia su preferencia.");
//
//	                recursoA.liberar(nombre, this);
//
//	                // Intercambio roles: ahora quiero el otro recurso
//	                Recurso tmp = recursoA;
//	                recursoA = recursoB;
//	                recursoB = tmp;
//
//	                dormir(10);
//	                continue;
//	                
//	                
//	            }else {
//	            	ConsoleDebug.log(nombre, " ve que " + recursoB.getNombre()
//                    + " está OCUPADO, así que sigue trabajando en " + recursoA.getNombre());
//	            }
//
//	            dormir(10);
//	        }
	    }

	    private void dormir(long millis) {
	        try {
	            Thread.sleep(millis);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
}
