package model.factory.impl;

import model.Deambulante;
import model.Posicion;
import model.Rico;
import model.factory.DeambulanteCreator;
import state.RateroState;

public class RicoCreator extends DeambulanteCreator {

    @Override
    public Deambulante crearDeambulante(Posicion posicion, Integer velodicad, Integer botin, RateroState estadoActual) {
        // Aquí podrías inyectar config, dinero inicial, etc.
        return new Rico();
    }
	
}
