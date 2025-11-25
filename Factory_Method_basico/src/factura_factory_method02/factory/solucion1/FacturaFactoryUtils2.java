package factura_factory_method02.factory.solucion1;

import java.util.HashMap;
import java.util.Map;

import factura_factory_method02.factory.FacturaFactory;
import factura_factory_method02.factory.impl.FacturaConIvaFactory;
import factura_factory_method02.factory.impl.FacturaConIvaMasDescuentoNavidadFactory;
import factura_factory_method02.factory.impl.FacturaConIvaReducidoFactory;
import factura_factory_method02.factory.impl.FacturaConIvaYDescuentoFamiliaNumerosaFactory;
import factura_factory_method02.factory.impl.FacturaSinIvaFactory;
import factura_factory_method02.model.Factura;

public class FacturaFactoryUtils2 {

    private final Map<Integer, FacturaFactory> creadores = new HashMap<>();

    public FacturaFactoryUtils2() {
        // Registro inicial (podría venir de config, de BD, etc.)
        creadores.put(1, new FacturaConIvaFactory());
        creadores.put(2, new FacturaSinIvaFactory());
        creadores.put(3, new FacturaConIvaReducidoFactory());
        creadores.put(4, new FacturaConIvaMasDescuentoNavidadFactory());
        creadores.put(5, new FacturaConIvaYDescuentoFamiliaNumerosaFactory());
    }

    // Permite registrar nuevos tipos en tiempo de ejecución
    public void register(Integer tipo, FacturaFactory creator) {
        creadores.put(tipo, creator);
    }

    public Factura create(Integer tipo, Integer cantidad, Double importe) {
    	FacturaFactory creator = creadores.get(tipo);
        if (creator == null) {
            throw new IllegalArgumentException("Tipo de factura no soportado: " + tipo);
        }
        return creator.createFactura(cantidad, importe);
    }
}
