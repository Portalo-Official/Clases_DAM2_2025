package antes;

public enum Frezzer_Transfomation_Enum {

	PRIMERA_FORMA (0. ),
	SEGUNDA_FORMA (1500.),
	TERCERA_FORMA (3000.),
	FORMA_FINAL (4500.),
	GOLDEN_FREEZER (8000.),
	;

	private Double kiMinimo;
	
	Frezzer_Transfomation_Enum(Double kiMinimo) {
		this.kiMinimo = kiMinimo;
	}
	public Double getKiMinimo() {
		return kiMinimo;
	}

}
