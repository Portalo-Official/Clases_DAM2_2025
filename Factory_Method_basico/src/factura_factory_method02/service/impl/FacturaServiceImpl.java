package factura_factory_method02.service.impl;

import factura_factory_method02.factory.FacturaFactoryUtils;
import factura_factory_method02.factory.solucion2.FacturaFactoryUtils3;
import factura_factory_method02.factory.solucion2.FacturaTipoEnum;
import factura_factory_method02.model.Factura;
import factura_factory_method02.service.FacturaService;



public class FacturaServiceImpl implements FacturaService{

	@Override
	public Double CalcularImporte( Integer tipoFactura ,Integer numeroFactura, 
									Integer cantidad,	Double importe, String cliente) {
		//Corroborar datos en base de dato etc
		//...
		//
		
		Factura factura = FacturaFactoryUtils.createFactura(cantidad, importe, tipoFactura);
		
		
		Double importeFinal = factura.getImporte();
		//EnviarEmail a cliente
		
		//Enviar cosas al gestor de la empresa
		return importeFinal;
	}
	

	
	
	
	
	
	
	
	
//		FacturaFactoryUtils3 factoria = new FacturaFactoryUtils3();
//		
//		FacturaTipoEnum tipoFacturaEnum = FacturaTipoEnum.getTipoFacturaByCodigo(tipoFactura);
//		
//		Factura factura = factoria.create(tipoFacturaEnum, cantidad, importe);
}
