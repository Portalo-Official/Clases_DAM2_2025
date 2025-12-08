package a02_recursos_compartidos.hilo;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Una clase que cambia el valor de un array en un indice en concreto
 */
public class ConsumidorArray implements Runnable{
	
	private int[] arrayStock;
	private int index;
	private int variacion;
	private String name;
	private static int numeroNombre=0;
	
	@Override
	public void run() {
		
		int signo = (variacion > 0 ) ? 1 : -1;
		
		for (int i=0; i <= Math.abs(this.variacion); i ++) {
			
			this.arrayStock[index] += signo;
			
			System.out.println(this.name+": "+Arrays.toString(arrayStock));
		}
		
	}
	
	
	public ConsumidorArray(int[] arrayStock, int index, int variacion) {
		super();
		this.arrayStock = arrayStock;
		this.variacion = variacion;
		if(index < 0) {
			throw new IllegalArgumentException("El index no puede ser negativo");
		}else if( index >= arrayStock.length) {
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
