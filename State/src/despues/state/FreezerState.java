package despues.state;

import java.util.Date;

import despues.context.Freezer;
import despues.context.Frezzer_Transfomation_Enum;

public abstract class FreezerState {


	protected final Freezer context;
    protected final Frezzer_Transfomation_Enum tipo;

    protected FreezerState(Freezer context, Frezzer_Transfomation_Enum tipo) {
        this.context = context;
        this.tipo = tipo;
    }
    
    /**
     * Cada estado tendrá un comportamiento distinto para atacar.
     * IMPORTANTE: normalmente aquí se modificará el ki
     * y al final se llamará a evaluarCambioDeFormaPorKi().
     */
    public abstract void atacar();

    /**
     * Cada estado tendrá un comportamiento distinto para recargar Ki.
     * (piénsalo como "un turno de recarga" o "acción de recarga").
     */
    public abstract void recargarKi();

    /**
     * Cada estado decide cómo regenera usos con el tiempo.
     */
    public abstract void regenerarMovimientosInstantaneos(int segundosTranscurridos);

    /**
     * Cada estado decide cuánto ki cuesta el movimiento instantáneo.
     */
    public abstract double getCosteKiMovimientoInstantaneo();

    /**
     * AQUÍ está la magia del patrón State:
     * cada estado decide si, con el ki actual, se queda igual,
     * sube o baja de forma.
     */
    public abstract void evaluarCambioDeFormaPorKi();

    public Frezzer_Transfomation_Enum getTipo() {
        return tipo;
    }

    protected int getMaxMovimientosInstantaneos() {
        return tipo.getMovimientosInstantaneosMax();
    }
    
    // --- Lógica común ---

    public void defenderAtaque(double puntosDePoder) {
        context.perderKi(puntosDePoder * 0.25);
        System.out.println("[" + tipo + "] Freezer defiende. Ki restante: " + context.getKi());
        evaluarCambioDeFormaPorKi();
    }
    
    /**
     * Lógica común para el movimiento instantáneo:
     * - Regenerar usos según el tiempo.
     * - Comprobar límites.
     * - Cobrar ki.
     */
    public void movimientoInstantaneo() {
        long ahora = System.currentTimeMillis();
        Date ultimo = context.getUltimoMovimientoInstantaneo();

        if (ultimo != null) {
            long diffMs = ahora - ultimo.getTime();
            int segundos = (int) (diffMs / 1000);

            regenerarMovimientosInstantaneos(segundos);
        }

        if (context.getMovimientoInstantaneoContador() >= getMaxMovimientosInstantaneos()) {
            System.out.println("[" + tipo + "] No puedes usar más movimientos instantáneos.");
            return;
        }

        double costeKi = getCosteKiMovimientoInstantaneo();
        if (context.getKi() < costeKi) {
            System.out.println("[" + tipo + "] No tienes ki suficiente para moverte instantáneamente.");
            return;
        }

        context.perderKi(costeKi);
        context.setMovimientoInstantaneoContador(context.getMovimientoInstantaneoContador() + 1);
        context.setUltimoMovimientoInstantaneo(new Date(ahora));

        System.out.println("[" + tipo + "] Movimiento instantáneo usado. Ki: " + context.getKi() +
                " (" + context.getMovimientoInstantaneoContador() + "/" + getMaxMovimientosInstantaneos() + ")");

        evaluarCambioDeFormaPorKi();
    }
}
