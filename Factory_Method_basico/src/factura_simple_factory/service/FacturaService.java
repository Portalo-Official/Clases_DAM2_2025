package factura_simple_factory.service;

import factura_simple_factory.factory.FactoryFactura;
import factura_simple_factory.model.Factura;

public class FacturaService {

	
	Double CalcularImporte( int tipoFactura ,Integer numeroFactura, 
							Integer cantidad,	Double importe, String cliente){
		//Corroborar datos en base de dato etc
		//...
		//
		
		
		Factura factura = FactoryFactura.createFactura(cantidad, importe, tipoFactura);
		
		Double importeFinal = factura.getImporte();
		
		
		//EnviarEmail a cliente
		
		//Enviar cosas al gestor de la empresa
		return importeFinal;
	}
	
	
	
}
