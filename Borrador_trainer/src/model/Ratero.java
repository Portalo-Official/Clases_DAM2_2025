package model;

import state.RateroState;

public class Ratero implements Accionable, Deambulante {
	private Posicion posicion;
	private Integer velodicad;
	private Rico objetivo;
	private Integer botin;
	private Boolean enPersecucion; // idea 
	private Boolean estaEncarrcelado; // idea 
	private RateroState estadoActual;
	
	
	
	public Ratero(Posicion posicion, Integer velodicad, Rico objetivo, Integer botin, RateroState estadoActual) {
		super();
		this.posicion = posicion;
		this.velodicad = velodicad;
		this.objetivo = objetivo;
		this.botin = botin;
		this.enPersecucion = false;
		this.estaEncarrcelado = false;
		this.estadoActual = estadoActual;
	}


	@Override
	public void hacerUnMovimiento() {
		// TODO Auto-generated method stub
		
	}

	public RateroState getEstadoActual() {
		return estadoActual;
	}

	public void cambiarEstadoActual(RateroState estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Integer getVelodicad() {
		return velodicad;
	}

	public void setVelodicad(Integer velodicad) {
		this.velodicad = velodicad;
	}

	public Rico getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Rico objetivo) {
		this.objetivo = objetivo;
	}

	public Integer getBotin() {
		return botin;
	}

	public void setBotin(Integer botin) {
		this.botin = botin;
	}

	public Boolean getEnPersecucion() {
		return enPersecucion;
	}

	public void setEnPersecucion(Boolean enPersecucion) {
		this.enPersecucion = enPersecucion;
	}

	public Boolean getEstaEncarrcelado() {
		return estaEncarrcelado;
	}

	public void setEstaEncarrcelado(Boolean estaEncarrcelado) {
		this.estaEncarrcelado = estaEncarrcelado;
	}
	
	
	
}
