package a05_comsumer_producto.recurso;

import java.util.concurrent.ArrayBlockingQueue;

// Esto es el recurso 
public class CintaTraspotadora implements Cinteable {

	private ArrayBlockingQueue<String> productos;
	private final int topeProductoEnCinta= 15;
	
	public CintaTraspotadora(ArrayBlockingQueue<String> productos) {
		super();
		this.productos = productos;
	}

	public CintaTraspotadora() {
		super();
		this.productos = new ArrayBlockingQueue<>(topeProductoEnCinta);
	}
	
	@Override
	public synchronized void addProducto(String producto) throws InterruptedException {
		//Mas cosas 
		
		if(this.topeProductoEnCinta <= this.productos.size()) {
			wait();// Aqui me quedo hasta que me digan que continue
		}
		
		productos.add(producto);
		
		notifyAll();
	}
	
	@Override
	public synchronized String cogerProducto() throws InterruptedException {
		if(estaVacia()) {
			wait(); // Aqui se queda
		}
		String producto =  this.productos.remove();
		
		 notifyAll();
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
