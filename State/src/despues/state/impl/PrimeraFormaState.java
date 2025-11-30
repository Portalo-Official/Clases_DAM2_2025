package despues.state.impl;

import despues.context.Freezer;
import despues.context.Frezzer_Transfomation_Enum;
import despues.state.FreezerState;

public class PrimeraFormaState extends FreezerState{
		
	   public PrimeraFormaState(Freezer context) {
	        super(context, Frezzer_Transfomation_Enum.PRIMERA_FORMA);
	    }

	    @Override
	    public void atacar() {
	        int base = 100;
	        int dano = base + 10;
	        double costeKiAtaque = 50;

	        if (context.getKi() < costeKiAtaque) {
	            System.out.println("[PRIMERA_FORMA] No tienes ki suficiente para atacar.");
	            return;
	        }

	        context.perderKi(costeKiAtaque);
	        System.out.println("[PRIMERA_FORMA] Ataca causando " + dano +
	                " puntos de daño. Ki: " + context.getKi());

	        evaluarCambioDeFormaPorKi();
	    }

	    @Override
	    public void recargarKi() {
	        double kiPorTurno = tipo.getRegeneracion(); // 12.7 por turno
	        context.aumentarKi(kiPorTurno);
	        System.out.println("[PRIMERA_FORMA] Recarga " + kiPorTurno + " de ki. Total: " + context.getKi());

	        evaluarCambioDeFormaPorKi();
	    }

	    @Override
	    public void regenerarMovimientosInstantaneos(int segundosTranscurridos) {
	        if (segundosTranscurridos >= 30) {
	            context.setMovimientoInstantaneoContador(0);
	        }
	    }

	    @Override
	    public double getCosteKiMovimientoInstantaneo() {
	        return 150;
	    }

	    @Override
	    public void evaluarCambioDeFormaPorKi() {
	        double ki = context.getKi();
	        if (ki >= Frezzer_Transfomation_Enum.SEGUNDA_FORMA.getKiMinimo()) {
	            context.cambiarEstado(new SegundaFormaState(context));
	        }

	    }

}
