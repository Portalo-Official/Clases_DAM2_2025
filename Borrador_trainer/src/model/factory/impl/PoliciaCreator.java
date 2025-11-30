package model.factory.impl;

import model.Deambulante;
import model.Policia;
import model.Posicion;
import model.factory.DeambulanteCreator;
import state.RateroState;

public class PoliciaCreator extends DeambulanteCreator {

    @Override
    public Deambulante crearDeambulante(Posicion posicion, Integer velodicad, Integer botin, RateroState estadoActual) {
        // Se le mete los parámetros que necesite!
    	
    	// Esta clase sabe la logica para crearr una instancia de policia
    	//poner el uniforme
    	//ajustarse el paquete
    	// RRevisar carterra, si lleva la placa, si no la lleva no se crea
        return new Policia(velodicad);
    }
	
}
