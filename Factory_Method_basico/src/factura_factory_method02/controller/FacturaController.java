package factura_factory_method02.controller;

import factura_factory_method02.factory.FacturaFactory;
import factura_factory_method02.factory.impl.FacturaConIvaFactory;
import factura_factory_method02.factory.impl.FacturaConIvaMasDescuentoNavidadFactory;
import factura_factory_method02.factory.impl.FacturaSinIvaFactory;
import factura_factory_method02.model.Factura;
import factura_factory_method02.service.FacturaService;

public class FacturaController {
	
	private FacturaService facturaService; 
	
	/*
	 * No podemos tener varios controller para separar facturas segun la llamada del metodo.
	 */
	
	public Double getImporte(Integer cantidad, Double Importe, String cliente, Integer tipoDeFactura) {
		
		return facturaService.CalcularImporte(tipoDeFactura, tipoDeFactura, cantidad, Importe, cliente);
	}
	
}
