package a02_recursos_compartidos.app;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import a02_recursos_compartidos.hilo.ConsumidorArray02;

public class App_Safe02 {

	public static void main(String[] args) {
			
			int[] storage = {5, 4, 2, 7, 8, 3};
			
			ConsumidorArray02 consumidor1 = new ConsumidorArray02(storage, 0, -1000000);
			ConsumidorArray02 consumidor2 = new ConsumidorArray02(storage, 1, 1000000);
			ConsumidorArray02 consumidor3 = new ConsumidorArray02(storage, 0, 1000000);
			
	
			
//			Thread hilo1 = new Thread(consumidor1); 
//			Thread hilo2 = new Thread(consumidor2); 
//			Thread hilo3 = new Thread(consumidor3); 
//			
//			hilo1.start();
//			hilo2.start();
//			hilo3.start();
//			
//			try {
//				Thread.sleep(9500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("final"+Arrays.toString(storage));
			
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
