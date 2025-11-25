package factura_factory_method02.factory.solucion2;

import java.util.HashMap;
import java.util.Map;

import factura_factory_method02.factory.FacturaFactory;
import factura_factory_method02.model.Factura;

public class FacturaFactoryUtils3 {

	    private final Map<FacturaTipoEnum, FacturaFactory> creadores = new HashMap<>();

	    public FacturaFactoryUtils3() {
	        FacturaTipoEnum.getTiposFacturas().stream()
	        						.forEach( e -> {
	        							creadores.put(e, e.getFactoria());
	        						});
	    }

	    public Factura create(FacturaTipoEnum tipo, Integer cantidad, Double importe) {
	    	FacturaFactory creator = creadores.get(tipo);
	        if (creator == null) {
	            throw new IllegalArgumentException("Tipo de factura no soportado: " + tipo);
	        }
	        return creator.createFactura(cantidad, importe);
	    }
}

