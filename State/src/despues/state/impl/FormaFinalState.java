package despues.state.impl;

import despues.context.Freezer;
import despues.context.Frezzer_Transfomation_Enum;
import despues.state.FreezerState;

public class FormaFinalState extends FreezerState {


    public FormaFinalState(Freezer context) {
        super(context, Frezzer_Transfomation_Enum.FORMA_FINAL);
    }

    @Override
    public void atacar() {
        int base = 100;
        int dano = base + 300;
        double costeKiAtaque = 200;

        if (context.getKi() < costeKiAtaque) {
            System.out.println("[FORMA_FINAL] No tienes ki suficiente para atacar.");
            return;
        }

        context.perderKi(costeKiAtaque);
        System.out.println("[FORMA_FINAL] Ataca causando " + dano +
                " puntos de daño. Ki: " + context.getKi());

        evaluarCambioDeFormaPorKi();
    }

    @Override
    public void recargarKi() {
        double kiPorTurno = tipo.getRegeneracion(); // 25.8 por turno
        context.aumentarKi(kiPorTurno);
        System.out.println("[FORMA_FINAL] Recarga " + kiPorTurno + " de ki. Total: " + context.getKi());

        evaluarCambioDeFormaPorKi();
    }

    @Override
    public void regenerarMovimientosInstantaneos(int segundosTranscurridos) {
        // Ejemplo: cada 5s se resetean todos los usos
        if (segundosTranscurridos >= 5) {
            context.setMovimientoInstantaneoContador(0);
        }
    }

    @Override
    public double getCosteKiMovimientoInstantaneo() {
        return 300;
    }

    @Override
    public void evaluarCambioDeFormaPorKi() {
        double ki = context.getKi();

        // Subir a Golden Freezer
        if (ki >= Frezzer_Transfomation_Enum.GOLDEN_FREEZER.getKiMinimo()) {
            context.cambiarEstado(new GoldenFreezerState(context));
            context.getEstadoActual().evaluarCambioDeFormaPorKi(); 
        }

        // Bajar de forma final hacia abajo según el ki
        if (ki < Frezzer_Transfomation_Enum.FORMA_FINAL.getKiMinimo()) {
            context.cambiarEstado(new TerceraFormaState(context));
              
            context.getEstadoActual().evaluarCambioDeFormaPorKi();
        }
        
    }

}
