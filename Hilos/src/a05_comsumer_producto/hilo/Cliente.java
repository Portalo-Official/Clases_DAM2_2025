package a05_comsumer_producto.hilo;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import a05_comsumer_producto.recurso.Cinteable;
import util.ConsoleDebug;

public class Cliente implements Runnable{

	private Cinteable cinta;
	private Queue<String> carrito ;
	
	public Cliente(Cinteable cinta) {
		super();
		this.cinta = cinta;
		this.carrito = new ConcurrentLinkedQueue<>();
		
		for (int i = 0 ; i <= Math.random()*150 ; i++) {
			carrito.add(GeneradorProductos.generarProducto(0));
		}
		
	}



	@Override
	public void run() {
		
		while(this.carrito.size()>0) {
			dormir(45);
			//Tiene productos -> Es una List<> (genera aleatoria).
			
//			if(!this.cinta.estaLlena()) {
				
				ConsoleDebug.log(Thread.currentThread().getName(), "Añado producto");
	
				try {
					
					// Coger un producto y ponerlo en la cinta.
					this.cinta.addProducto( carrito.poll());
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			}
			
			ConsoleDebug.log(Thread.currentThread().getName(), "cinta llena, esperando...");
			
		}
		ConsoleDebug.log(Thread.currentThread().getName(), "Acabe de vaciar el carrito");
		
		
	}



	private void dormir(int millis)  {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
