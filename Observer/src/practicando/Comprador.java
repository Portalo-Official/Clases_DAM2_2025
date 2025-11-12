package practicando;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Comprador implements PropertyChangeListener{
	private String name;
	private String apellido;
	
	
	public Comprador(String name, String apellido) {
		super();
		this.name = name;
		this.apellido = apellido;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		evt.getNewValue(); // obetnemos el valor que ha cambiado (valor nuevo)
		evt.getOldValue(); // obetnemos el valor que ha cambiado (valor viejo)
		evt.getPropertyName();
		
		System.out.println("Obtuve mi nuevo Producto: "+ ((Producto) evt.getNewValue()).toString());
		
		System.out.println("Antes no habia :( "+((Producto) evt.getOldValue()).toString());
		
	}
	
	
	
}
