package factura_simple_factory.factory;

import java.util.Objects;

import factura_simple_factory.model.Factura;
import factura_simple_factory.model.FacturaConIva;
import factura_simple_factory.model.FacturaConIvaReducido;
import factura_simple_factory.model.FacturaConIvaYDescuentoFamiliaNumerosa;
import factura_simple_factory.model.FacturaSinIva;


public class FactoryFactura {

	public static Factura createFactura(Integer cantidad, Double importe, Integer tipoFactura) {
		
		Factura factura= null;
		
		if(Objects.equals(tipoFactura, 1)) {
			
			factura = new FacturaConIva(cantidad, importe);
			
		}else if(Objects.equals(tipoFactura, 2)) {
			factura = new FacturaSinIva(cantidad, importe); 
			
		}else if(Objects.equals(tipoFactura, 2)) {
			factura = new FacturaConIvaReducido(cantidad, importe); 
			
		}else if(Objects.equals(tipoFactura, 3)) {
			
			factura = new FacturaConIvaYDescuentoFamiliaNumerosa(cantidad, importe); 
		}
		
		return factura;
	}
	
	
}
