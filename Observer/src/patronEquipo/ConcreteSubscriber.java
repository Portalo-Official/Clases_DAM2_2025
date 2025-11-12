package patronEquipo;

public class ConcreteSubscriber<T> implements Subscriber<T> {

	
	
	@Override
	public void update(T context) {
		System.out.print("Me llego info nueva: ");
		System.out.println(context);
		
	}

}
