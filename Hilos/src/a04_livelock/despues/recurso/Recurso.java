package a04_livelock.despues.recurso;

import java.util.concurrent.atomic.AtomicBoolean;

public class Recurso {

    private final String nombre;
    private final AtomicBoolean ocupado = new AtomicBoolean(false);
    private Runnable hilo=null;
    private final AtomicBoolean dandoPaso = new AtomicBoolean(false);
    
    public Recurso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * El hilo "pregunta" al recurso si puede usarlo:
     * intenta pasar de false -> true.
     */
    public boolean intentarOcupar(String trabajador, Runnable locker) {
        if (ocupado.compareAndSet(false, true)) {
        	this.hilo = locker;
            System.out.println(trabajador + " ha adquirido " + nombre);
            return true;
        } else {
            System.out.println(trabajador + " NO puede adquirir " + nombre);
            return false;
        }
    }

    public void liberar(String trabajador, Runnable locker) {
    	
        // Solo lo libera quien lo ha adquirido
        if (this.hilo.equals(locker) 
    		&& ocupado.compareAndSet(true, false)) {
        	
            System.out.println(trabajador + " ha liberado " + nombre);
        }
    }
    
    public boolean estaLibre() {
    	
       return this.ocupado.get();
    }
    
    public void darPaso(boolean paso) {
    	
    	 this.dandoPaso.set(paso);;
    }
    
    public boolean estaDandoPaso() {
    	
    	return this.dandoPaso.get();
    } 
    
}
