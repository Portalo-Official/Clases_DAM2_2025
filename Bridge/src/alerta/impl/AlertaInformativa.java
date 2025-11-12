package alerta.impl;

import alerta.Alerta;
import canal.Canal;

public class AlertaInformativa extends Alerta {
    public AlertaInformativa(Canal canal) {
        super(canal);
    }

    @Override
    protected String asunto() {
        return "ℹ️ INFO";
    }
}
