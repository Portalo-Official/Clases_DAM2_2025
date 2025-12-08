package a05_comsumer_producto.hilo;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import a05_comsumer_producto.recurso.Cinteable;
import util.ConsoleDebug;

public class CajeraMercadona implements Runnable{

	private Cinteable cinta;
	private Queue<String> factura ;
	
	
	
	public CajeraMercadona(Cinteable cinta) {
		super();
		this.cinta = cinta;
		this.factura = new ConcurrentLinkedQueue<>();
	}



	@Override
	public void run() {
		boolean tocaDescansito = false;
		int pasadas = 0;
		
		// Va a coger producto
		while(!tocaDescansito) {
			
//			 if(!this.cinta.estaVacia()) {
					 
				 try {
				
					 String producto = cinta.cogerProducto(); // Aqui
					 
					 ConsoleDebug.log(Thread.currentThread().getName(), "Cojo producto");
					 // Va a cobrarlo
					this.factura.add(producto);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			 }
		
			dormir(45);
			pasadas ++;
			if(pasadas >= 2500) {
				tocaDescansito = true;
			}
		}
		
		ConsoleDebug.log(Thread.currentThread().getName(), "Acabe mi tarea");
		// Genera factura
		
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
