package alerta.impl;

import alerta.Alerta;
import canal.Canal;

public class AlertaCritica extends Alerta {
    public AlertaCritica(Canal canal) {
        super(canal);
    }

    @Override
    protected String asunto() {
        return "⚠️ CRÍTICA";
    }

    @Override
    protected String prepararCuerpo(String mensaje) {
        // Ejemplo de comportamiento adicional para críticas
        return "[PRIORIDAD ALTA] " + mensaje;
    }
}
