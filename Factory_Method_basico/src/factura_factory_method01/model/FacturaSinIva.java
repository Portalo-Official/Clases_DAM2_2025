
package factura_factory_method01.model;

public class FacturaSinIva implements Factura{
	
	private int numero;
	private Double importe;

	public FacturaSinIva(int numero, Double importe) {
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
