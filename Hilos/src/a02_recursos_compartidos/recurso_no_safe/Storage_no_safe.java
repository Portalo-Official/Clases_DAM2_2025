package a02_recursos_compartidos.recurso_no_safe;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

public class Storage_no_safe {
	private int[] stockProductos;
	private Date ultimaModificacion; 
	
	public Storage_no_safe(int[] stockProductos) {
		super();
		this.stockProductos = stockProductos;
		this.ultimaModificacion = Date.from(Instant.now());
	}
	
	public void variarStock(int index, int value) {
		this.stockProductos[index] += value;
		this.ultimaModificacion = Date.from(Instant.now());
	}
	
	/**
	 * Devuelve una copia de {@link #stockProductos}
	 * 
	 * @return Copia de {@link #stockProductos}
	 */
	public int[] getStockProductosClone() {
		return Arrays.copyOf(this.stockProductos, this.stockProductos.length);
	}

	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}

	public int getCantidadElementos() {
		return this.stockProductos.length;
	}
	
	
}
