package model.factory.impl;

import model.Deambulante;
import model.Posicion;
import model.Ratero;
import model.factory.DeambulanteCreator;
import state.RateroState;

public class RateroCreator extends DeambulanteCreator {

    @Override
    public Deambulante crearDeambulante(Posicion posicion, Integer velodicad, Integer botin, RateroState estadoActual) {
        // Aquí podrías configurar radio de acción, botín objetivo, etc.
        return new Ratero( posicion, velodicad, null,  botin, estadoActual); 
    }
	
}
