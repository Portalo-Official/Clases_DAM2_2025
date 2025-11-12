package practicando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Cliente {

	@Test
	void test() {
		
		Shein shein = new Shein(new Producto("Air Force chinubi"));
		Comprador elena = new Comprador("Elena", "Zambrano");
		
		shein.subscribe(elena);
		shein.nuevoStock(5);
		shein.setProducto(new Producto("chaqueta"));
		shein.nuevoStock(10);
		
	}

}
