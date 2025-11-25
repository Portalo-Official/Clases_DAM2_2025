package factura_mal01.service;

import java.util.Objects;

import factura_mal01.model.FacturaConIva;
import factura_mal01.model.FacturaConIvaReducido;
import factura_mal01.model.FacturaConIvaYDescuentoFamiliaNumerosa;
import factura_mal01.model.FacturaSinIva;

public class FacturaService {

	
	Double CalcularImporte( int tipoFactura ,Integer numeroFactura, 
							Integer cantidad, Double importe, String cliente){
		//Corroborar datos en base de dato etc
		//...
		//
		Double importeFinal = 0d;
		
		
		if(Objects.equals(tipoFactura, 1)) {
			
			FacturaConIva factura = new FacturaConIva(cantidad, importe);
			
			importeFinal = factura.getImporte();
			
		}else if(Objects.equals(tipoFactura, 2)) {
			FacturaSinIva factura = new FacturaSinIva(cantidad, importe); 
			
			importeFinal = factura.getImporte();		
		}else if(Objects.equals(tipoFactura, 3)) {
			FacturaConIvaReducido factura = new FacturaConIvaReducido(cantidad, importe); 
			
			importeFinal = factura.getImporte();		
		}else if(Objects.equals(tipoFactura, 4)) {
			FacturaConIvaYDescuentoFamiliaNumerosa factura = new FacturaConIvaYDescuentoFamiliaNumerosa(cantidad, importe); 
			
			importeFinal = factura.getImporte();		
		}
		
		
		//EnviarEmail a cliente
		
		//Enviar cosas al gestor de la empresa
		return 0d;
	}
	
	
	
}
