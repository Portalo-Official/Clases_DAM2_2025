package model;

public class Policia implements Accionable, Deambulante{
	
	private Ratero perseguido;
	private Integer velocidad;
	
	public Policia( Integer velocidad) {
		super();
		this.perseguido = null;
		this.velocidad = velocidad;
	}


	@Override
	public void hacerUnMovimiento() {
		// TODO Auto-generated method stub
		
	}

	public Ratero getPerseguido() {
		return perseguido;
	}
	
	public void setPerseguido(Ratero perseguido) {
		this.perseguido = perseguido;
	}
	
	public Integer getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}


}
