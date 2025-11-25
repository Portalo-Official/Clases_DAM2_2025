package factura_factory_method01.service.impl;

import factura_factory_method01.model.Factura;
import factura_factory_method01.service.FacturaService;



public class FacturaServiceImpl implements FacturaService{

	@Override
	public Double CalcularImporte(Factura factura, String cliente) {
		//Corroborar datos en base de dato etc
		//...
		//
		
		Double importeFinal = factura.getImporte();
		
		//EnviarEmail a cliente
		
		//Enviar cosas al gestor de la empresa
		return null;
	}
	
	
	
}
