package canal.impl;

import canal.Canal;

public class SMSCanal implements Canal {

	@Override
    public void enviar(String asunto, String cuerpo) {
        System.out.println("[SMS] " + asunto + " - " + cuerpo);
    }

}
