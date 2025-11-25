package factura_factory_method01.factory;

import factura_factory_method01.model.Factura;

public abstract class FacturaFactory {

	// Metodo abstracto que implementara cada hijo
	public abstract Factura createFactura(Integer cantidad, Double importe);
	
	
	
	public Object algunaLogicaDeNegocio(Integer cantidad, Double importe) {
		//Este metodo puede tener negocio de como gestionar las calse
		//y también hacer uso del metodo abstracto
		
		Factura factura = createFactura(cantidad, importe);
		
		factura.getImporte();
		
		return null;
	}
	
	
	
}
