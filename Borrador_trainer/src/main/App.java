package main;

import java.util.Random;

import model.Deambulante;
import model.Policia;
import model.Posicion;
import model.Ratero;
import model.Rico;
import model.factory.DeambulanteCreator;
import model.factory.impl.PoliciaCreator;
import model.factory.impl.RateroCreator;
import model.factory.impl.RicoCreator;
import state.RateroState;

public class App {

	public static void main(String[] args) {
		//for
		
		Posicion posicion = null;
		Integer velodicad = null;
		Integer botin = null;
		RateroState estadoActual = null;
		
		Integer rn = new Random().nextInt();
		
		DeambulanteCreator factory; // Creator
		
		if(rn == 1) {
			factory = new RicoCreator(); // ConcreteCreatorA
			
		}else if(rn == 2) {
			
			factory = new RateroCreator(); // ConcreteCreatorB
		}else {
		
			factory = new PoliciaCreator(); // ConcreteCreatorC
		}
		
		
		// Product
		Deambulante ciudadano1 = factory.crearDeambulante(posicion, velodicad , botin, estadoActual );
		
		
	}
	
	
	public void  factory(String[] args) {
		//for
		
		Posicion posicion = null;
		Integer velodicad = null;
		Integer botin = null;
		RateroState estadoActual = null;
		
		Integer rn = new Random().nextInt();
		
		DeambulanteCreator factory; // Creator
		
		if(rn == 1) {
			factory = new RicoCreator(); // ConcreteCreatorA
			
		}else if(rn == 2) {
			
			factory = new RateroCreator(); // ConcreteCreatorB
		}else {
		
			factory = new PoliciaCreator(); // ConcreteCreatorC
		}
		
		// Product
		Deambulante ciudadano1 = factory.crearDeambulante(posicion, velodicad , botin, estadoActual );
			
	}
	
	public void factoryIdeaOrigen(String[] args) {
		// Como podria estar ?? 
		
		// For
		Posicion posicion = null;
		Integer velodicad = null;
		Integer botin = null;
		RateroState estadoActual = null;
		
		Integer rn = new Random().nextInt();
		
		Deambulante ciudadano; // Padre creador
		
		if(rn == 1) {
			ciudadano = new Rico();
			
		}else if(rn == 2) {
			
			ciudadano = new Ratero(posicion, rn, null, rn, estadoActual);
		}else {
		
			ciudadano = new Policia(velodicad);
		}	
		
	}
	
}
