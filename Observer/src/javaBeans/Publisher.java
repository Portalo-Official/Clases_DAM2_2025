package javaBeans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Publisher {
	private final PropertyChangeSupport pcs= new PropertyChangeSupport(this);
	private String value;
	private String nombre;
	
	
	public Publisher(String value, String nombre) {
		super();
		this.value = value;
		this.nombre = nombre;
	}

	// addObserver(observer)
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String newValue) {
		String oldValue = this.value;
		this.value = newValue;
		this.pcs.firePropertyChange("event_name", oldValue, newValue);
	}
}
