package a02_recursos_compartidos.app;

import java.util.concurrent.atomic.AtomicIntegerArray;

import a02_recursos_compartidos.hilo.ConsumidorArray01;

public class App_Safe01 {

	public static void main(String[] args) {
		
		AtomicIntegerArray storage = new AtomicIntegerArray(new int[]{5, 4, 2, 7, 8, 3});
			
		ConsumidorArray01 consumidor1 = new ConsumidorArray01(storage, 0, -1000000);
		ConsumidorArray01 consumidor2 = new ConsumidorArray01(storage, 1, 1000000);
		ConsumidorArray01 consumidor3 = new ConsumidorArray01(storage, 0, 1000000);
			
	
			
			Thread hilo1 = new Thread(consumidor1); 
			Thread hilo2 = new Thread(consumidor2); 
			Thread hilo3 = new Thread(consumidor3); 
			
			hilo1.start();
			hilo2.start();
			hilo3.start();
			
			try {
				Thread.sleep(9500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("final"+storage.toString());
			
			/**
			 * El hilo ahora tiene synchronized(arrayStock) para bloquear el recurso 
			 * y evitar la condición de carrera.
			 */	
			
//			ExecutorService executor = Executors.newCachedThreadPool();
//			executor.execute(consumidor1);
//			executor.execute(consumidor2);
//			executor.execute(consumidor3);
//			
//			executor.shutdown();
			
		}

}
