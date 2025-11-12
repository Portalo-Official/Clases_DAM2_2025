package alerta;

import canal.Canal;

/**
 * Abstraction del Bridge.
 * Mantiene una referencia al Implementor (Canal) y delega el envío.
 */
public abstract class Alerta {
    protected final Canal canal;

    protected Alerta(Canal canal) {
        this.canal = canal;
    }

    /** Hook: cada subtipo decide cómo construir el asunto. */
    protected abstract String asunto();

    /** Hook: cada subtipo puede enriquecer el mensaje. */
    protected String prepararCuerpo(String mensaje) {
        return mensaje;
    }

    /** Template method que usa ambos hooks y delega en el canal. */
    public void notificar(String mensaje) {
        canal.enviar(asunto(), prepararCuerpo(mensaje));
    }
    
}