package patronEquipo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Cliente {

	@Test
	void test() {
		ConcretePublisher<String> shein = new ConcretePublisher<String>("No tengo ropa");
		ConcreteSubscriber<String> compradorCompulsivo = new ConcreteSubscriber<String>();
		// Pulso el boton avisame cuando haya stock
		shein.subcribe(compradorCompulsivo);
		shein.mainBussinesLogic("Ropita Linda");
	}

}
