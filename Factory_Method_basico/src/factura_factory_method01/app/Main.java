package factura_factory_method01.app;

import factura_factory_method01.factory.FacturaFactory;
import factura_factory_method01.factory.impl.FacturaConIvaFactory;
import factura_factory_method01.factory.impl.FacturaSinIvaFactory;
import factura_factory_method01.model.Factura;

public class Main {

	
	public static void main(String[] args) {
		
		FacturaFactory factoria = new FacturaConIvaFactory();
		
		FacturaFactory factoria2 = new FacturaSinIvaFactory();
			
		Factura factura = factoria.createFactura(2, 34.78);
		Factura factura2 = factoria2.createFactura(2, 34.78);
		
		System.out.println(factura);
		System.out.println();
		System.out.println(factura2);
		
		
	}
	
	
}
