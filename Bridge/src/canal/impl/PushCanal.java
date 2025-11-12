package canal.impl;

import canal.Canal;

public class PushCanal implements Canal {

	@Override
	public void enviar(String asunto, String cuerpo) {
		System.out.println("[PUSH] "+asunto+ " - "+ cuerpo);

	}

}
