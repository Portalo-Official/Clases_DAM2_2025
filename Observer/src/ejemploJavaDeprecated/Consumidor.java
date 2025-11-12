package ejemploJavaDeprecated;

import java.util.Observable;
import java.util.Observer;

public class Consumidor implements Observer{

	private Object mio;
	
	@Override
	public void update(Observable o, Object arg) {
		this.mio= arg;
		
	}

	public Object getMio() {
		return mio;
	}

}
