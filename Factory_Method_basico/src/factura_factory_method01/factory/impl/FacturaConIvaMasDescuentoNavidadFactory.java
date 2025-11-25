package factura_factory_method01.factory.impl;

import factura_factory_method01.factory.FacturaFactory;
import factura_factory_method01.model.Factura;
import factura_factory_method01.model.FacturaConIvaMasDescuentoNavidad;

public class FacturaConIvaMasDescuentoNavidadFactory extends FacturaFactory{

	@Override
	public Factura createFactura(Integer cantidad, Double importe) {
		
		return new FacturaConIvaMasDescuentoNavidad(cantidad, importe);
	}

}
