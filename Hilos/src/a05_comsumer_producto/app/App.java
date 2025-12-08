package a05_comsumer_producto.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import a05_comsumer_producto.hilo.CajeraMercadona;
import a05_comsumer_producto.hilo.Cliente;
import a05_comsumer_producto.recurso.CintaTraspotadora;
import a05_comsumer_producto.recurso.CintaTraspotadoraMarrullera;
import a05_comsumer_producto.recurso.Cinteable;

public class App {

	public static void main(String[] args) {
		
		
		Cinteable cinta = new CintaTraspotadora();
//		Cinteable cinta = new CintaTraspotadoraMarrullera();
		
		CajeraMercadona cajera = new CajeraMercadona(cinta);
		Cliente cliente = new Cliente(cinta);
		
//		Thread hilo1 = new Thread( cliente);
//		Thread hilo2 = new Thread( cajera);
//		
//		hilo1.setName("Hilo1");
//		hilo2.setName("Hilo2");
//		
//		hilo1.start();
//		hilo2.start();
		
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.execute(cajera);
		executor.execute(cliente);
		
	}
	
}
