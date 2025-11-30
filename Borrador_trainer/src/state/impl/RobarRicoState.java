package state.impl;

import model.Ratero;
import state.RateroState;

public class RobarRicoState implements RateroState {

	private Ratero context;
	

	
	public RobarRicoState(Ratero context) {
		this.context = context;
	}


	public void metodoCualquiera () {
		
		if(context.getEnPersecucion()) {
			context.cambiarEstadoActual(new HuidaDeRoboState(context));
		};
	}
}
