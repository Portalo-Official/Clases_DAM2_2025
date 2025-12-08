package a03_deadlock.antes.hilo;

import a03_deadlock.antes.recurso.RecursoA;
import a03_deadlock.antes.recurso.RecursoB;

public class consumidorServicionDos implements Runnable{


	private RecursoB recursoB;
	private RecursoA recursoA;
	
	@Override
	public void run() {
		
		 // Bloquea el primer recurso
        System.out.println(Thread.currentThread().getName() +
                " intentando bloquear " + recursoB.getNombre() + "...");
        
        
        
        synchronized (recursoB) {
            System.out.println(Thread.currentThread().getName() +
                    " bloqueó " + recursoB.getNombre());

            
            dormirUnPoco(); // Para dar tiempo al otro hilo a bloquear el otro recurso

            // Intenta bloquear el segundo recurso
            System.out.println(Thread.currentThread().getName() +
                    " intentando bloquear " + recursoA.getNombre() + "...");
            
            
            
            synchronized (recursoA) {
                System.out.println(Thread.currentThread().getName() +
                        " bloqueó " + recursoA.getNombre());
            }
        }
	}
	
	
    private void dormirUnPoco() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    
	public consumidorServicionDos(RecursoB recursoB, RecursoA recursoA) {
		super();
		this.recursoB = recursoB;
		this.recursoA = recursoA;
	}

}
