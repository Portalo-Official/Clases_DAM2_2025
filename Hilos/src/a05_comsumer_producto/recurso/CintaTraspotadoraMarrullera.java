package a05_comsumer_producto.recurso;

import java.util.concurrent.ArrayBlockingQueue;

// Esto es el recurso 
public class CintaTraspotadoraMarrullera implements Cinteable {

	private ArrayBlockingQueue<String> productos;
	private final int topeProductoEnCinta= 15;
	
	public CintaTraspotadoraMarrullera(ArrayBlockingQueue<String> productos) {
		super();
		this.productos = productos;
	}

	public CintaTraspotadoraMarrullera() {
		super();
		this.productos = new ArrayBlockingQueue<>(topeProductoEnCinta);
	}
	
	@Override
	public void addProducto(String producto) throws InterruptedException {
		productos.add(producto);
		
	}
	
	@Override
	public String cogerProducto() throws InterruptedException {
	
		String producto =  this.productos.remove();
		
		return producto;
	}
	
	@Override
	public boolean estaVacia() {
		return this.productos.isEmpty();
	}

	@Override
	public boolean estaLlena() {
		return this.topeProductoEnCinta <= this.productos.size();
	}
	
}
