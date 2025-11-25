package factura_factory_method02.factory;

import java.util.Objects;

import factura_factory_method02.factory.impl.FacturaConIvaFactory;
import factura_factory_method02.factory.impl.FacturaConIvaMasDescuentoNavidadFactory;
import factura_factory_method02.factory.impl.FacturaConIvaReducidoFactory;
import factura_factory_method02.factory.impl.FacturaConIvaYDescuentoFamiliaNumerosaFactory;
import factura_factory_method02.factory.impl.FacturaSinIvaFactory;
import factura_factory_method02.model.Factura;
import factura_factory_method02.utils.ConstantesFactura;



public class FacturaFactoryUtils {

	public static Factura createFactura(Integer cantidad, Double importe, Integer tipoFactura) {
		
		FacturaFactory  factory;
		
		
		if(Objects.equals(tipoFactura, ConstantesFactura.FACTURA_CON_IVA)) {
			
			factory = new FacturaConIvaFactory();
			
		}else if(Objects.equals(tipoFactura, ConstantesFactura.FACTURA_SIN_IVA)) {
			factory = new FacturaSinIvaFactory();
			
		}else if(Objects.equals(tipoFactura, ConstantesFactura.FACTURA_CON_IVA_REDUCIDO)) {
			factory = new FacturaConIvaReducidoFactory();
			
		}else if(Objects.equals(tipoFactura, ConstantesFactura.FACTURA_CON_IVA_Y_DESCUENTO_FAMILIA_NUMEROSA)) {
			factory = new FacturaConIvaYDescuentoFamiliaNumerosaFactory();
			
		}else if(Objects.equals(tipoFactura, ConstantesFactura.FACTURA_CON_IVA_Y_DESCUENTO_FAMILIA_NUMEROSA)) {
			factory = new FacturaConIvaMasDescuentoNavidadFactory();
			
		}
		else {
			factory = new FacturaConIvaFactory();
		}
		
		Factura factura= factory.createFactura(cantidad, importe);
		
		return factura;
	}
	
}
