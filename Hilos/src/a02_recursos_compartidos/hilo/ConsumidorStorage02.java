package a02_recursos_compartidos.hilo;

import java.util.Arrays;

import a02_recursos_compartidos.recurso_safe.Storage_safe;

/**
 * Una clase que cambia el valor de un array en un indice en concreto
 */
public class ConsumidorStorage02 implements Runnable{
	
	private Storage_safe storage;
	private int index;
	private int variacion;
	private String name;
	private static int numeroNombre=0;
	
	@Override
	public void run() {
		
		int signo = (variacion > 0 ) ? 1 : -1;
		
		for (int i=0; i <= Math.abs(this.variacion); i ++) {
			// Bloqueamos recurso
			synchronized (storage) {
				this.storage.variarStock(this.index, signo);
				
			}
			
			System.out.println(this.name+": "+Arrays.toString(storage.getStockProductosClone()));
		}
		
	}
	
	
	public ConsumidorStorage02(Storage_safe storage, int index, int variacion) {
		super();
		this.storage = storage;
		this.variacion = variacion;
		if(index < 0) {
			throw new IllegalArgumentException("El index no puede ser negativo");
		}else if( index >= storage.getCantidadElementos()) {
			throw new IllegalArgumentException("El index no puede ser mayor a la longitud del array");
		}
		this.index = index;
		this.name = asignarNombre();
		
	}


	private String asignarNombre() {
		String nombre =  "Consumidor "+numeroNombre;
		incrementarNumeroNombre();
		return nombre;
	}
	
	private static void incrementarNumeroNombre() {
		numeroNombre ++;
	}
}
