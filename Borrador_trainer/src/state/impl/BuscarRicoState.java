package state.impl;

import model.Ratero;
import model.Rico;
import state.RateroState;

public class BuscarRicoState implements RateroState {

	private Ratero context;
	
	
	public BuscarRicoState(Ratero context) {

		this.context = context;
	}

	public void buscarObjetivo() {
		
		// Si encuentra objetivo, lo fija (setRico) y cambia el state
		context.setObjetivo(new Rico());
		context.cambiarEstadoActual(new AlcanzarRicoState(context));
		
	}

	public void metodoCualquiera() {
		
		if(context.getEnPersecucion()) {
			context.cambiarEstadoActual(new HuidaDeRoboState(context));
		};
	}
	
}
