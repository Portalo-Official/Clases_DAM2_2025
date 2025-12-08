package a02_recursos_compartidos.recurso_safe;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Storage_safe {
	private AtomicIntegerArray stockProductos;
	private volatile Date ultimaModificacion; 
	
	/**
	 * Volatile tiene que ver con visibilidad de memoria, no con atomicidad.
	 * 
	 * obliga a que las lecturas/escrituras vayan a memoria principal, 
	 * no a una copia local del hilo.
	 */
	
	/**
	 * Constrructor con variable atomica
	 * @param stockProductos
	 */
	public Storage_safe(AtomicIntegerArray stockProductos) {
		super();
		this.stockProductos = stockProductos;
		this.ultimaModificacion = Date.from(Instant.now());
	}
	
	public void variarStock(int index, int value) {
		this.stockProductos.addAndGet(index, value);
		this.ultimaModificacion = Date.from(Instant.now());
	}
	
	/**
	 * Devuelve una copia de {@link #stockProductos}
	 * 
	 * @return Copia de {@link #stockProductos}
	 */
	public synchronized  int[] getStockProductosClone() {
		// usamos syncrronized por que al copia en el bucle puede 
		// venir otro hilo y cambiar un valor anteior
		int[] copia = new int[stockProductos.length()];
		for (int i = 0; i < copia.length; i++) {
		    copia[i] = stockProductos.get(i);
		}
				
		return copia;
	}

	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}

	public int getCantidadElementos() {
		return this.stockProductos.length();
	}
	
	
	
	/**
	 * Según ChatGPT
	 * 
	 * Atómico significa: Esta operación no se puede partir en trozos 
	 * 					   visibles para otros hilos. Es como si pulsaras 
	 * 					   un botón que hace todo el trabajo de golpe.
	 * 
	 * Volatile significa: Cuando un hilo cambie esta variable, los demás 
	 * 					   la van a ver actualizada enseguida y en orden. 
	 * 					   Es un tema de visibilidad y orden, no de hacer 
	 * 					   operaciones compuestas seguras.
	 */
	
}
