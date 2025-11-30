package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CuerpoPolicia implements Accionable, PropertyChangeListener {
	
	private List<Policia> policias = new ArrayList<>();
	
	@Override
	public void hacerUnMovimiento() {
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if(evt.getPropertyName().equals("Robo")) {
			Ratero ratero = (Ratero) evt.getNewValue();
			
			// Buscar al policia con la posicion mas crerca del ratero
			
			Policia policiaCercano = buscarPoliciaCerca(ratero);
			
			policiaCercano.setPerseguido(ratero);
			ratero.setEnPersecucion(true);
		}
		
		
	}

	
	private Policia buscarPoliciaCerca(Ratero ratero) {
		// obetnemos las posicion para buscar al poli mas cercano
		Posicion posicionRatero = ratero.getPosicion();
		
		Policia policiaCercano = this.policias.get(0);
		
		for (Policia policia : this.policias) {
			
			// Aqui habra algo con las posiciones donde
			// operaciones con coordenadas para ver al cercano
			policia = policiaCercano;
		}
		
		
		return policiaCercano;
	}

}
