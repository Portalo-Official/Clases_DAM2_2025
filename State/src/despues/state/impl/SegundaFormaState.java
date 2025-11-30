package despues.state.impl;

import despues.context.Freezer;
import despues.context.Frezzer_Transfomation_Enum;
import despues.state.FreezerState;

public class SegundaFormaState extends FreezerState{
		
    public SegundaFormaState(Freezer context) {
        super(context, Frezzer_Transfomation_Enum.SEGUNDA_FORMA);
    }

    @Override
    public void atacar() {
        int base = 100;
        int dano = base + 50;
        double costeKiAtaque = 80;

        if (context.getKi() < costeKiAtaque) {
            System.out.println("[SEGUNDA_FORMA] No tienes ki suficiente para atacar.");
            return;
        }

        context.perderKi(costeKiAtaque);
        System.out.println("[SEGUNDA_FORMA] Ataca causando " + dano +
                " puntos de daño. Ki: " + context.getKi());

        evaluarCambioDeFormaPorKi();
    }

    @Override
    public void recargarKi() {
        double kiPorTurno = tipo.getRegeneracion(); // 15.2 por turno
        context.aumentarKi(kiPorTurno);
        System.out.println("[SEGUNDA_FORMA] Recarga " + kiPorTurno + " de ki. Total: " + context.getKi());

        evaluarCambioDeFormaPorKi();
    }

    @Override
    public void regenerarMovimientosInstantaneos(int segundosTranscurridos) {
        if (segundosTranscurridos >= 20) {
            int actual = context.getMovimientoInstantaneoContador();
            context.setMovimientoInstantaneoContador(Math.max(0, actual - 1));
        }
    }

    @Override
    public double getCosteKiMovimientoInstantaneo() {
        return 200;
    }

    @Override
    public void evaluarCambioDeFormaPorKi() {
        double ki = context.getKi();
 
        // Subir a tercera forma
        if (ki >= Frezzer_Transfomation_Enum.TERCERA_FORMA.getKiMinimo()) {
            context.cambiarEstado(new TerceraFormaState(context));
            return;
        }

        // Bajar a primera forma
        if (ki < Frezzer_Transfomation_Enum.SEGUNDA_FORMA.getKiMinimo()) {
            context.cambiarEstado(new PrimeraFormaState(context));
        }
        
        
    }

}
