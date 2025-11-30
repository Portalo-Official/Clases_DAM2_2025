package despues.state.impl;

import despues.context.Freezer;
import despues.context.Frezzer_Transfomation_Enum;
import despues.state.FreezerState;

public class GoldenFreezerState extends FreezerState{

	   public GoldenFreezerState(Freezer context) {
	        super(context, Frezzer_Transfomation_Enum.GOLDEN_FREEZER);
	    }

	    @Override
	    public void atacar() {
	        int base = 100;
	        int dano = base + 600;
	        double costeKiAtaque = 300;

	        if (context.getKi() < costeKiAtaque) {
	            System.out.println("[GOLDEN_FREEZER] No tienes ki suficiente para atacar.");
	            return;
	        }

	        context.perderKi(costeKiAtaque);
	        System.out.println("[GOLDEN_FREEZER] Ataca causando " + dano +
	                " puntos de daño. Ki: " + context.getKi());

	        evaluarCambioDeFormaPorKi();
	    }

	    @Override
	    public void recargarKi() {
	        double kiPorTurno = tipo.getRegeneracion(); // 45.2 por turno
	        context.aumentarKi(kiPorTurno);
	        System.out.println("[GOLDEN_FREEZER] Recarga " + kiPorTurno + " de ki. Total: " + context.getKi());

	        evaluarCambioDeFormaPorKi();
	    }

	    @Override
	    public void regenerarMovimientosInstantaneos(int segundosTranscurridos) {
	        // Golden: roto total. Siempre dejamos el contador a 0.
	        context.setMovimientoInstantaneoContador(0);
	    }

	    @Override
	    public double getCosteKiMovimientoInstantaneo() {
	        return 400;
	    }

	    @Override
	    public void evaluarCambioDeFormaPorKi() {
	        double ki = context.getKi();

	        // Golden es la forma máxima, solo puede bajar UNA forma
	        if (ki < Frezzer_Transfomation_Enum.GOLDEN_FREEZER.getKiMinimo()) {
	            context.cambiarEstado(new FormaFinalState(context));
	        }
	        
	        context.getEstadoActual().evaluarCambioDeFormaPorKi();
	    }
}
