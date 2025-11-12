package ejemploJavaDeprecated;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientJava {

	@Test
	void test() {
		Proveedor shein = new Proveedor(null);
		Consumidor chicaGastona = new Consumidor();
		
		shein.addObserver(chicaGastona);
		shein.setArg("Ropita linda");
		
		System.out.println(chicaGastona.getMio());
		
	}

}
