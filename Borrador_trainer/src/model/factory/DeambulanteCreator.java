package model.factory;

import model.Deambulante;
import model.Posicion;
import state.RateroState;

public abstract class DeambulanteCreator {
	
	// Factory Method
    public abstract Deambulante crearDeambulante(Posicion posicion, Integer velodicad, Integer botin, RateroState estadoActual);
    
}
