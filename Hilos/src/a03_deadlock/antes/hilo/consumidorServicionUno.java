package a03_deadlock.antes.hilo;

import a03_deadlock.antes.recurso.RecursoA;
import a03_deadlock.antes.recurso.RecursoB;

public class consumidorServicionUno implements Runnable{

	private RecursoA recursoA;
	private RecursoB recursoB;
	
	@Override
	public void run() {
		
		 // Bloquea el primer recurso
        System.out.println(Thread.currentThread().getName() +
                " intentando bloquear " + recursoA.getNombre() + "...");
        
        
        synchronized (recursoA) {
            System.out.println(Thread.currentThread().getName() +
                    " bloqueó " + recursoA.getNombre());

            dormirUnPoco(); // Para dar tiempo al otro hilo a bloquear el otro recurso

            // Intenta bloquear el segundo recurso
            System.out.println(Thread.currentThread().getName() +
                    " intentando bloquear " + recursoB.getNombre() + "...");
            
            
            synchronized (recursoB) {
                System.out.println(Thread.currentThread().getName() +
                        " bloqueó " + recursoB.getNombre());
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

	public consumidorServicionUno(RecursoA recursoA, RecursoB recursoB) {
		super();
		this.recursoA = recursoA;
		this.recursoB = recursoB;
	}
    
    
}
