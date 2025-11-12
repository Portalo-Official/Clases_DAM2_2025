package patron;

public class ConcreteSubscribers<T> implements Subscriber<T>{
	private String name;
	
	public ConcreteSubscribers(String name) {
		this.name = name;
	}

	@Override
	public void update(T context) {
		System.out.println(this.name+": Me he enterado");
	}

	

}
