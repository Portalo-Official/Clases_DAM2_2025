package javaBeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Subcriber implements PropertyChangeListener{
	private String name;
	
	
	public Subcriber(String name) {
		super();
		this.name = name;
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Soy "+this.name);
		System.out.println("Ha ocurrido un evento");
		System.out.println(evt.getPropertyName()+" antiguo: "+evt.getOldValue());
		System.out.println(evt.getPropertyName()+" nuevo: "+evt.getNewValue());
		System.out.println("----------\n");
	
	}

}
