package model;

public class Posicion {
	private Float coordX;
	private Float coordY;
	
	public Posicion(Float coordX, Float coordY) {
		super();
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public Posicion(Posicion posicion) {
		super();
		this.coordX = posicion.getCoordX();
		this.coordY = posicion.getCoordY();
	}

	public Float getCoordX() {
		return this.coordX;
	}

	public void setCoordX(Float coordX) {
		this.coordX = coordX;
	}

	public Float getCoordY() {
		return this.coordY;
	}

	public void setCoordY(Float coordY) {
		this.coordY = coordY;
	}
	
	
}
