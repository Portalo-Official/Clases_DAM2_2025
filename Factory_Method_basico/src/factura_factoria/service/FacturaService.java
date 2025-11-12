package factura_factoria.service;

import java.util.Objects;

import factura_factoria.model.FacturaConIva;
import factura_factoria.model.FacturaConIvaReducido;
import factura_factoria.model.FacturaSinIva;



public class FacturaService {

	
	Double CalcularImporte( int tipoFactura ,Integer numeroFactura, Double importe, String cliente){
		//Corroborar datos en base de dato etc
		//...
		//
		Double importeFinal = 0d;
		
		
		if(Objects.equals(numeroFactura, 1)) {
			
			FacturaConIva factura = new FacturaConIva(tipoFactura, importe);
			
			importeFinal = factura.getImporte();
			
		}else if(Objects.equals(numeroFactura, 2)) {
			FacturaSinIva factura = new FacturaSinIva(tipoFactura, importeFinal); 
			
			importeFinal = factura.getImporte();		
		}else if(Objects.equals(numeroFactura, 2)) {
			FacturaConIvaReducido factura = new FacturaConIvaReducido(tipoFactura, importeFinal); 
			
			importeFinal = factura.getImporte();		
		}
		
		
		//EnviarEmail a cliente
		
		//Enviar cosas al gestor de la empresa
		return 0d;
	}
	
	
	
}
