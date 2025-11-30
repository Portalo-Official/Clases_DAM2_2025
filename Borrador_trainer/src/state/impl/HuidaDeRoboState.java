package state.impl;

import model.Ratero;
import state.RateroState;

public class HuidaDeRoboState implements RateroState {

	private Ratero context;
	
	public HuidaDeRoboState(Ratero context) {
		super();
		this.context = context;
		this.context.setVelodicad(3242);
	}

	public void metodoCualquiera () {
		
		if(context.getEnPersecucion()) {
			context.cambiarEstadoActual(new HuidaDeRoboState(context));
		};
	}
}
