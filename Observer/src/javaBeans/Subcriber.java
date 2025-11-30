package javaBeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class Subcriber implements PropertyChangeListener{
	private String name;
	
	
	public Subcriber(String name) {
		super();
		this.name = name;
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// Para ver el nombre del evento
		//System.out.println("Clave de evt es null: "+Objects.isNull(evt.getPropertyName()));
		//System.out.println("Soy "+evt.getPropertyName());
		System.out.println("Soy "+this.name);
		System.out.println("Ha ocurrido un evento");
		System.out.println(evt.getPropertyName()+" antiguo: "+evt.getOldValue());
		System.out.println(evt.getPropertyName()+" nuevo: "+evt.getNewValue());
		System.out.println("----------\n");
	
	}

}
