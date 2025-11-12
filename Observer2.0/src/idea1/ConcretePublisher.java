package idea1;

import java.util.HashSet;
import java.util.Set;


public class ConcretePublisher<T> implements Publisher<T> {

	private Set<Subscriber<T>> subscribers;
	private T mainState;
	
	
	public ConcretePublisher(T mainState) {
		super();
		this.mainState = mainState;
		this.subscribers = new HashSet<>();
	}

	@Override
	public boolean subcribe(Subscriber<T> s) {
		return this.subscribers.add(s);
	}

	@Override
	public boolean unSubcribe(Subscriber<T> s) {
		return this.subscribers.remove(s);
	}

	@Override
	public void notifySubscriber() {
		this.subscribers.forEach(subscriber->subscriber.update( mainState));
	}
	
	public void mainBussinesLogic(T mainState) {
		this.mainState=mainState;
		notifySubscriber();
	}

}
