package ejemploJavaDeprecated;

import java.util.Observable;
import java.util.Observer;

public class Proveedor extends Observable{
	Object argumento;
	
	public Proveedor(Observer observer) {
		if(observer!=null)
			addObserver(observer);
	}
	
	public Object getArg() {
		return argumento;
	}

	public void setArg(Object arg) {
		this.argumento = arg;
		setChanged();
		notifyObservers(arg);
//		notifyObservers();
	}
	
	
}
