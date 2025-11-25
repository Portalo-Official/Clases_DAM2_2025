package factura_factory_method02.app;

import factura_factory_method02.factory.solucion2.FacturaFactoryUtils3;
import factura_factory_method02.factory.solucion2.FacturaTipoEnum;
import factura_factory_method02.model.Factura;

public class Main {

	
	public static void main(String[] args) {
		
		
		FacturaFactoryUtils3 factoria = new FacturaFactoryUtils3();
		
		FacturaTipoEnum tipoFacturaEnum = FacturaTipoEnum.getTipoFacturaByCodigo(3);
		
		Factura factura = factoria.create(tipoFacturaEnum, 2, 34.89);
		
		
		System.out.println(factura);
		
	}
}
