package patron;

import java.util.ArrayList;
import java.util.List;

public class ConcretePublisher implements Publisher{
	private List<Subscriber> subcribers;
	
	private boolean mainState;

	public ConcretePublisher(boolean mainState) {
		super();
		this.mainState = mainState;
		this.subcribers = new ArrayList<>();
	}
	
	@Override
	public boolean subscribe(Subscriber subcriber) {
		return this.subcribers.add(subcriber);
	}
	@Override
	public boolean unSubcriber(Subscriber subcriber) {
		return subcribers.remove(subcriber);
	}
	@Override
	public void notifySubscribers() {
//		this.subcribers.forEach(subscriber-> subscriber.update(this));
		this.subcribers.forEach(subscriber-> subscriber.update("En Stock"));
	}
	
	public void mainBusinerssLogic(boolean mainState, String masCosas) {
		this.mainState=mainState;
		System.out.println("Cosas de la logica de negocio: "+ masCosas);
		if(mainState)
			notifySubscribers();
	}
	
}
