package factura_factory_method01.model;

public class FacturaConIvaMasDescuentoNavidad implements Factura{

	private int numero;
	private Double importe;

	public FacturaConIvaMasDescuentoNavidad(int numero, Double importe) {
		super();
		this.numero = numero;
		this.importe = importe;
	}

	public Double getImporte() {
		return importe*(1+0.21)*0.75;
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
