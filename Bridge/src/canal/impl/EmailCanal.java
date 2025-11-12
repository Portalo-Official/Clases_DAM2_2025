package canal.impl;

import canal.Canal;

public class EmailCanal implements Canal {
    @Override
    public void enviar(String asunto, String cuerpo) {
        System.out.println("[EMAIL] " + asunto + " - " + cuerpo);
    }
}
