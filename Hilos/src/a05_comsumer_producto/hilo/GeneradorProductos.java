package a05_comsumer_producto.hilo;

import java.util.Random;

public class GeneradorProductos {

    private static final String[] NOMBRES = {
            "jamón", "queso", "leche", "pan", "huevos",
            "café", "galletas", "yogur", "tomate", "patatas"
        };

        private static final Random RANDOM = new Random();

        public static String generarProducto(int numero) {
            String base = NOMBRES[RANDOM.nextInt(NOMBRES.length)];
            // algo tipo "jamón #1", "queso #2", etc.
            return base + " #" + numero;
        }
	
}
