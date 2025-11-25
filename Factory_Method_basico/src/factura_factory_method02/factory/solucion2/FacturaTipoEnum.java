package factura_factory_method02.factory.solucion2;

import java.util.List;
import java.util.Objects;

import factura_factory_method02.factory.FacturaFactory;
import factura_factory_method02.factory.impl.FacturaConIvaFactory;
import factura_factory_method02.factory.impl.FacturaConIvaMasDescuentoNavidadFactory;
import factura_factory_method02.factory.impl.FacturaConIvaReducidoFactory;
import factura_factory_method02.factory.impl.FacturaConIvaYDescuentoFamiliaNumerosaFactory;
import factura_factory_method02.factory.impl.FacturaSinIvaFactory;

public enum FacturaTipoEnum {

	FACTURA_CON_IVA(1, new FacturaConIvaFactory()),
	ACTURA_SIN_IV(2, new FacturaSinIvaFactory()) ,
	FACTURA_CON_IVA_REDUCIDO(3, new FacturaConIvaReducidoFactory()) ,
	FACTURA_CON_IVA_Y_DESCUENTO_FAMILIA_NUMEROSA(4, new FacturaConIvaMasDescuentoNavidadFactory()) ,
	FACTURA_CON_IVA_MAS_DESCUENTO_NAVIDAD(5,  new FacturaConIvaYDescuentoFamiliaNumerosaFactory()) ;

	private Integer codigoTipoFactura;
	private FacturaFactory factoria;

	private FacturaTipoEnum(Integer codigoTipoFactura, FacturaFactory factoria) {
		this.codigoTipoFactura = codigoTipoFactura;
		this.factoria = factoria;
	}
	
	public FacturaFactory getFactoria() {
		return factoria;
	}
	
	public static List<FacturaTipoEnum> getTiposFacturas(){
		return List.of(FacturaTipoEnum.values());
	}
	
	public static FacturaTipoEnum getTipoFacturaByCodigo(Integer codigo){
		return List.of(FacturaTipoEnum.values()).stream()
									.filter( e -> Objects.equals(e.codigoTipoFactura, codigo))
									.findFirst()
									.orElseThrow( ()-> new IllegalArgumentException(
									        "No existe un FacturaTipoEnum con el código: " + Objects.toString(codigo)));
	}
}
