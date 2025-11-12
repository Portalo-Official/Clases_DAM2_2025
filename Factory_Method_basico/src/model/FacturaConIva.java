package model;

public class FacturaConIva {
	private int numero;
	private Double importe;

	public FacturaConIva(int numero, Double importe) {
		super();
		this.numero = numero;
		this.importe = importe;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
