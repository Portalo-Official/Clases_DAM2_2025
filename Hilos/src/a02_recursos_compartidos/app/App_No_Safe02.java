package a02_recursos_compartidos.app;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import a02_recursos_compartidos.hilo.ConsumidorArray;
import a02_recursos_compartidos.hilo.ConsumidorStorage;
import a02_recursos_compartidos.recurso_no_safe.Storage_no_safe;

public class App_No_Safe02 {

	
	public static void main(String[] args) {
		
		int[] storageArray = {5, 4, 2, 7, 8, 3};
		Storage_no_safe storage= new Storage_no_safe(storageArray);
		
		ConsumidorStorage consumidor1 = new ConsumidorStorage(storage, 0, -1000000);
		ConsumidorStorage consumidor2 = new ConsumidorStorage(storage, 1, 1000000);
		ConsumidorStorage consumidor3 = new ConsumidorStorage(storage, 0, 1000000);
		

		
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
		System.out.println("final"+Arrays.toString(storage.getStockProductosClone()));
		/**
		 * Condicion de carrera (race condition)
		 * 
		 * El hilo1 e hilo3 apuntan al mismo indice del array.
		 * El hilo2 apunta a otro indice solo, no afectara
		 * 
		 * Hilo 1 lee storage[0] → 5
		 *
		 * Hilo 3 lee storage[0] → 5
		 * 
		 * A calcula 5 + 1 → 6, lo escribe.
		 * 
		 * B calcula 5 - 1 → 4, lo escribe.
		 */	
		
		
		
		
//		ExecutorService executor = Executors.newCachedThreadPool();
//		executor.execute(consumidor1);
//		executor.execute(consumidor2);
//		executor.execute(consumidor3);
//		
//		try {
//			executor.wait();
//			System.out.println("final"+Arrays.toString(storage));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
