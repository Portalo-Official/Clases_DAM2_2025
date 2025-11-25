package factura_factory_method02.factory.impl;

import factura_factory_method02.factory.FacturaFactory;
import factura_factory_method02.model.Factura;
import factura_factory_method02.model.FacturaConIva;

public class FacturaConIvaFactory extends FacturaFactory{

	@Override
	public Factura createFactura(Integer cantidad, Double importe) {
		
		//Logica de Negocio que tiene el crear una factura
		if(cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad no es correcta");
		}
		
		if(importe <= 0) {
			throw new IllegalArgumentException("El importe no es correcto");
		}
		
		return new FacturaConIva(cantidad, importe);
	}

}
