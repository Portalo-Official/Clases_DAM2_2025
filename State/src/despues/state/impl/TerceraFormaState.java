package despues.state.impl;

import despues.context.Freezer;
import despues.context.Frezzer_Transfomation_Enum;
import despues.state.FreezerState;

public class TerceraFormaState extends FreezerState {

    public TerceraFormaState(Freezer context) {
        super(context, Frezzer_Transfomation_Enum.TERCERA_FORMA);
    }

    @Override
    public void atacar() {
        int base = 100;
        int dano = base + 150;
        double costeKiAtaque = 120;

        if (context.getKi() < costeKiAtaque) {
            System.out.println("[TERCERA_FORMA] No tienes ki suficiente para atacar.");
            return;
        }

        context.perderKi(costeKiAtaque);
        System.out.println("[TERCERA_FORMA] Ataca causando " + dano +
                " puntos de daño. Ki: " + context.getKi());

        evaluarCambioDeFormaPorKi();
    }

    @Override
    public void recargarKi() {
        double kiPorTurno = tipo.getRegeneracion(); // 25.8 por turno
        context.aumentarKi(kiPorTurno);
        System.out.println("[TERCERA_FORMA] Recarga " + kiPorTurno + " de ki. Total: " + context.getKi());

        evaluarCambioDeFormaPorKi();
    }

    @Override
    public void regenerarMovimientosInstantaneos(int segundosTranscurridos) {
        if (segundosTranscurridos >= 10) {
            context.setMovimientoInstantaneoContador(0);
        }
    }

    @Override
    public double getCosteKiMovimientoInstantaneo() {
        return 250;
    }

    @Override
    public void evaluarCambioDeFormaPorKi() {
        double ki = context.getKi();

        if (ki >= Frezzer_Transfomation_Enum.FORMA_FINAL.getKiMinimo()) {
            context.cambiarEstado(new FormaFinalState(context));
            
            context.getEstadoActual().evaluarCambioDeFormaPorKi(); 
        }

        if (ki < Frezzer_Transfomation_Enum.TERCERA_FORMA.getKiMinimo()) {
             context.cambiarEstado(new SegundaFormaState(context));
             
             context.getEstadoActual().evaluarCambioDeFormaPorKi();   
        }
    }

}
