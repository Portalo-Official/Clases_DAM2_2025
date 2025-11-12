package factura_factoria.model;

public class FacturaConIvaMasDescuentoNavidad {

	private int numero;
	private Double importe;

	public FacturaConIvaMasDescuentoNavidad(int numero, Double importe) {
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
