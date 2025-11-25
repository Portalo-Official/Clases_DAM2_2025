package factura_factory_method02.service;

import factura_factory_method02.model.Factura;

public interface FacturaService {
	

	Double CalcularImporte( Integer tipoFactura ,Integer numeroFactura, 
			Integer cantidad,	Double importe, String cliente);
}
