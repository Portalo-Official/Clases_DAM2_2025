package idea1;

import java.util.HashSet;
import java.util.Set;

public class ConcreteSubscriber<T> implements Subscriber<T> {

	private Set<Publisher> publishers;
	
	public ConcreteSubscriber(Set<Publisher> publisher) {
		super();
		this.publishers = publisher;
	}
	public ConcreteSubscriber() {
		super();
		this.publishers = new HashSet<>();
	}

	@Override
	public void update(T context) {
		System.out.print("Me llego info nueva: ");
		System.out.println(context);
		
	}
	
	public boolean subcribe(Publisher<T> publisher) {
		if(!isContains(publisher))
			if(publisher.subcribe(this))
				return this.publishers.add(publisher);
		return false;
	}
	
	public boolean unSubcribe(Publisher<T> publisher) {
		if(isContains(publisher))
			if(publisher.unSubcribe(this))
				return this.publishers.remove(publisher);
		return false;
	}
	
	private boolean isContains(Publisher<T> publisher) {
		return this.publishers.contains(publisher);
	}

}
