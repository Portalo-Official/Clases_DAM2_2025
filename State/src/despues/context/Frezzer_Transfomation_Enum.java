package despues.context;

public enum Frezzer_Transfomation_Enum {

	PRIMERA_FORMA (0., 120, 23.7d, 12.7, 2),
	SEGUNDA_FORMA (1500., 220, 29.0d, 15.2, 3),
	TERCERA_FORMA (3000. , 570, 43.8d, 25.8, 4),
	FORMA_FINAL (4500., 820, 68.8d, 25.8, 6),
	GOLDEN_FREEZER (8000., 1200, 120.0d, 45.2, 8),
	;

	private Double kiMinimo;
	private Integer poderExtra;
	private Double velocidadExtra;
	private Double regeneracion;
	private Integer movimientosInstantaneosMax;
	
	Frezzer_Transfomation_Enum(Double kiMinimo, Integer poderExtra, Double velocidadExtra, Double regeneracion,
							Integer movimientosInstantaneosMax) {
		this.poderExtra = poderExtra;
		this.velocidadExtra = velocidadExtra;
		this.regeneracion = regeneracion;
		this.movimientosInstantaneosMax = movimientosInstantaneosMax;
		this.kiMinimo = kiMinimo;
	}

	public Double getRegeneracion() {
		return regeneracion;
	}

	public Integer getPoderExtra() {
		return poderExtra;
	}
	
	public Double getKiMinimo() {
		return kiMinimo;
	}
	
	public Integer getMovimientosInstantaneosMax() {
		return movimientosInstantaneosMax;
	}

	public Double getVelocidadExtra() {
		return velocidadExtra;
	}

}
