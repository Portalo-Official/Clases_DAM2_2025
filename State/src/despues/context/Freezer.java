package despues.context;

import java.util.Date;

import despues.state.FreezerState;
import despues.state.impl.PrimeraFormaState;

public class Freezer {


    private double ki;
    private int velocidadBase;
    private double ph;

    private FreezerState estadoActual;

    private int movimientoInstantaneoContador = 0;
    private Date ultimoMovimientoInstantaneo;

    public Freezer(double kiInicial, int velocidadBase, double phInicial) {
        this.ki = kiInicial;
        this.velocidadBase = velocidadBase;
        this.ph = phInicial;
        this.estadoActual = new PrimeraFormaState(this);
        System.out.println("Freezer nace con ki=" + kiInicial + " en forma " + estadoActual.getTipo());
    }


    public void atacar() {
        estadoActual.atacar();
    }

    public void recargarKi() {
        estadoActual.recargarKi();
    }

    public void movimientoInstantaneo() {
        estadoActual.movimientoInstantaneo();
    }

    public void defenderAtaque(double puntosDePoder) {
        estadoActual.defenderAtaque(puntosDePoder);
    }

    public Frezzer_Transfomation_Enum getFormaActual() {
        return estadoActual.getTipo();
    }

    // ---- Operaciones de KI (NO deciden la forma) ----

    public void aumentarKi(double cantidad) {
        this.ki += cantidad;
        System.out.println("KI aumentado +" + cantidad + " => " + this.ki);
    }

    public void perderKi(double cantidad) {
        double total = this.ki - cantidad;
        if (total < 10) {
            this.ki = 10;
        } else {
            this.ki = total;
        }
        System.out.println("KI reducido -" + cantidad + " => " + this.ki);
    }

    // ---- Gestión del estado (solo usado por los states) ----

    public void cambiarEstado(FreezerState nuevoEstado) {
        System.out.println(">>> Freezer se transforma de " +
                (estadoActual != null ? estadoActual.getTipo() : "NINGUNA") +
                " a " + nuevoEstado.getTipo());
        this.estadoActual = nuevoEstado;
        this.movimientoInstantaneoContador = 0;
        this.ultimoMovimientoInstantaneo = null;
    }

    public double getKi() {
        return ki;
    }

    public int getMovimientoInstantaneoContador() {
        return movimientoInstantaneoContador;
    }

    public void setMovimientoInstantaneoContador(int contador) {
        this.movimientoInstantaneoContador = contador;
    }

    public Date getUltimoMovimientoInstantaneo() {
        return ultimoMovimientoInstantaneo;
    }

    public void setUltimoMovimientoInstantaneo(Date ultimoMovimientoInstantaneo) {
        this.ultimoMovimientoInstantaneo = ultimoMovimientoInstantaneo;
    }

	public FreezerState getEstadoActual() {
		return estadoActual;
	}
    	
}



