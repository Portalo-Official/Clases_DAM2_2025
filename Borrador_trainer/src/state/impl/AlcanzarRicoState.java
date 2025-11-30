package state.impl;

import model.Ratero;
import state.RateroState;

public class AlcanzarRicoState implements RateroState {

	private Ratero context;
	
	
	public AlcanzarRicoState(Ratero context) {
		this.context = context;
		this.context.setVelodicad(123123);
	}


	public void buscarPoliciaCerca () {
		
		//Busca policia cerca
		
		// Si no hay -> Roba
		context.cambiarEstadoActual(new RobarRicoState(context));
		
		// Si hay policia Cerca, deja el objetivo (cambia de estado)
		context.setObjetivo(null);
		context.cambiarEstadoActual(new BuscarRicoState(context));

	}
}
