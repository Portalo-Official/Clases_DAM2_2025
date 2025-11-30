package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * Patron Observer:
 * linea 13 -> pongo PropertyChangeSupport para que se apubliser
 * 
 */
public class Rico implements Accionable, Deambulante{
	private PropertyChangeSupport ps= new PropertyChangeSupport(this);
	private Integer dinero ;
	
	public Rico() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void hacerUnMovimiento() {
		// TODO Auto-generated method stub
		
	}

	public void agregarListener(PropertyChangeListener listener) {
		ps.addPropertyChangeListener(listener);
	}
	
	public void notifyRobo(Ratero ratero) { // O Deambulante por interfaz?
		
		// Un random aqui para ver si se dio cuenta o no ¿ a lo mejor en el codigo cliente
		if(dinero == 0) { // ?? algo para que se de cuenta que le robaron
			ps.firePropertyChange("Robo", false, ratero);
		}
		
	}
	
	public Integer getDinero() {
		return dinero;
	}

	public void setDinero(Integer dinero) {
		this.dinero = dinero;
	}

}
