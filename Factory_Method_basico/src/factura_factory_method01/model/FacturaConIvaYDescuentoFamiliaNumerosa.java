package factura_factory_method01.model;

public class FacturaConIvaYDescuentoFamiliaNumerosa implements Factura{

	private int numero;
	private Double importe;

	public FacturaConIvaYDescuentoFamiliaNumerosa(int numero, Double importe) {
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
