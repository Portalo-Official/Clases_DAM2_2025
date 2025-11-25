package factura_factory_method01.service;

import factura_factory_method01.model.Factura;

public interface FacturaService {
	

	Double CalcularImporte(Factura factura, String cliente);
}
