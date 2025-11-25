package factura_factory_method01.controller;

import factura_factory_method01.factory.FacturaFactory;
import factura_factory_method01.factory.impl.FacturaConIvaFactory;
import factura_factory_method01.factory.impl.FacturaConIvaMasDescuentoNavidadFactory;
import factura_factory_method01.factory.impl.FacturaSinIvaFactory;
import factura_factory_method01.model.Factura;
import factura_factory_method01.service.FacturaService;

public class FacturaController {
	
	private FacturaService facturaService; 
	
	public Double getImporteDeFacturaConIva(Integer cantidad, Double Importe, String cliente) {
		// Factory
		FacturaFactory factory = new FacturaConIvaFactory();
		
		Factura factura = factory.createFactura(cantidad, Importe);
		
		return facturaService.CalcularImporte(factura, cliente);
	}
	
	
	public Double getImporteDeFacturaSinIva(Integer cantidad, Double Importe, String cliente) {
		//Factory
		FacturaFactory factory = new FacturaSinIvaFactory();
		
		Factura factura = factory.createFactura(cantidad, Importe);
		
		return facturaService.CalcularImporte(factura, cliente);
	}
	
	
	
	public Double getImporteFacturaConIvaMasDescuentoNavidad(Integer cantidad, Double Importe, String cliente) {
		//Factory
		FacturaFactory factory = new FacturaConIvaMasDescuentoNavidadFactory();
		
		Factura factura = factory.createFactura(cantidad, Importe);
		
		return facturaService.CalcularImporte(factura, cliente);
	}
}
