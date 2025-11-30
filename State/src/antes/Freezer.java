package antes;

import java.util.Date;

public class Freezer { 
	private Double ki;
	private Integer velocidad;
	private Double ph;
	private Frezzer_Transfomation_Enum transformacion;

	// Se puede mover instantáneamente en un radio de 300 metros, pero está limitado según su transformación.
	private Integer movimientoInstantaneoContador = 0;
	private Integer movimientoInstantaneoMax = 1;
	private Date ultimoMovimientoInstantaneo; // los movimientos instantáneos se recuperan a X segundos
	
	public Freezer(Double kiInicial, Integer velocidadBase, Double phInicial) {
	    this.ki = kiInicial;
	    this.velocidad = velocidadBase;
	    this.ph = phInicial;
	    this.transformacion = Frezzer_Transfomation_Enum.PRIMERA_FORMA;
	    this.movimientoInstantaneoMax = 1;
	}
	
	
	// Cambiar de transformación
	public void transformar(Frezzer_Transfomation_Enum nuevaForma) {
	   
	    // lógica de negocio basada en IFs por cada transformación.
	    if (this.ki < nuevaForma.getKiMinimo()) {
	        System.out.println("No tienes ki suficiente para transformarte en " + nuevaForma);
	        return;
	    }
	
	    this.transformacion = nuevaForma;
	
	    // velocidad y movimientos instantáneos cambian según la forma
	    if (nuevaForma == Frezzer_Transfomation_Enum.PRIMERA_FORMA) {
	        this.velocidad = 100;
	        this.movimientoInstantaneoMax = 1;
	    } else if (nuevaForma == Frezzer_Transfomation_Enum.SEGUNDA_FORMA) {
	        this.velocidad = 150;
	        this.movimientoInstantaneoMax = 2;
	    } else if (nuevaForma == Frezzer_Transfomation_Enum.TERCERA_FORMA) {
	        this.velocidad = 200;
	        this.movimientoInstantaneoMax = 3;
	    } else if (nuevaForma == Frezzer_Transfomation_Enum.FORMA_FINAL) {
	        this.velocidad = 300;
	        this.movimientoInstantaneoMax = 5;
	    } else if (nuevaForma == Frezzer_Transfomation_Enum.GOLDEN_FREEZER) {
	        this.velocidad = 400;
	        this.movimientoInstantaneoMax = 8;
	    }
	
	    System.out.println("Freezer se ha transformado en " + nuevaForma +
	            " (velocidad=" + velocidad + ", maxMovInst=" + movimientoInstantaneoMax + ")");
	}
	
	/**
	 * Movimiento instantáneo.
	 * Lógica súper acoplada a la transformación actual.
	 */
	public void doMovimientoInstantaneo() {
	    long ahora = System.currentTimeMillis();
	
	    // 1) Regenerar el contador por tiempo (lógica distinta por transformación)
	    if (ultimoMovimientoInstantaneo != null) {
	        long diffMs = ahora - ultimoMovimientoInstantaneo.getTime();
	        int segundos = (int) (diffMs / 1000);
	
	        // REGLAS HARDCODEADAS DEPENDIENDO DEL ESTADO
	        if (transformacion == Frezzer_Transfomation_Enum.PRIMERA_FORMA) {
	            // En primera forma recupera 1 uso cada 15 segundos
	            if (segundos >= 15) {
	                movimientoInstantaneoContador = 0;
	            }
	            
	        } else if (transformacion == Frezzer_Transfomation_Enum.SEGUNDA_FORMA) {
	        	// En segunda forma recupera 1 uso cada 10 segundos
	        	if (segundos >= 10) {
	                movimientoInstantaneoContador = Math.max(0, movimientoInstantaneoContador - 1);
	            }
	        	
	        } else if (transformacion == Frezzer_Transfomation_Enum.TERCERA_FORMA) {
	            // En tercera forma recupera 1 uso cada 5 segundos
	            if (segundos >= 5) {
	                movimientoInstantaneoContador = Math.max(0, movimientoInstantaneoContador - 1);
	            }
	            
	        } else if (transformacion == Frezzer_Transfomation_Enum.FORMA_FINAL) {
	            // Forma final, recuperación rápida
	            if (segundos >= 3) {
	                movimientoInstantaneoContador = 0;
	            }
	        } else if (transformacion == Frezzer_Transfomation_Enum.GOLDEN_FREEZER) {
	            // Golden, OP total
	            movimientoInstantaneoContador = 0;
	        }
	    }
	
	    // 2) Comprobar si todavía le quedan movimientos instantáneos
	    if (movimientoInstantaneoContador >= movimientoInstantaneoMax) {
	        System.out.println("No puedes usar más movimientos instantáneos en esta forma.");
	        return;
	    }
	
	    // 3) Usar movimiento instantáneo -> consumir ki según la forma
	    double costeKi;
	    if (transformacion == Frezzer_Transfomation_Enum.PRIMERA_FORMA) {
	        costeKi = 150;
	    } else if (transformacion == Frezzer_Transfomation_Enum.SEGUNDA_FORMA) {
	        costeKi = 200;
	    } else if (transformacion == Frezzer_Transfomation_Enum.TERCERA_FORMA) {
	        costeKi = 250;
	    } else if (transformacion == Frezzer_Transfomation_Enum.FORMA_FINAL) {
	        costeKi = 300;
	    } else { // GOLDEN
	        costeKi = 400;
	    }
	
	    if (ki < costeKi) {
	        System.out.println("No tienes ki suficiente para moverte instantáneamente.");
	        return;
	    }
	
	    perderKi(costeKi);
	    movimientoInstantaneoContador++;
	    ultimoMovimientoInstantaneo = new Date(ahora);
	
	    System.out.println("Freezer usa movimiento instantáneo en " + transformacion +
	            ". Ki restante: " + ki +
	            ". Usos: " + movimientoInstantaneoContador + "/" + movimientoInstantaneoMax);
	}
	
	public Integer atacar() {
	    // Otro método que cambia mucho según la transformación
	    int base = 100;
	    int dano;
	
	    if (transformacion == Frezzer_Transfomation_Enum.PRIMERA_FORMA) {
	        dano = base + 10;
	    } else if (transformacion == Frezzer_Transfomation_Enum.SEGUNDA_FORMA) {
	        dano = base + 50;
	    } else if (transformacion == Frezzer_Transfomation_Enum.TERCERA_FORMA) {
	        dano = base + 150;
	    } else if (transformacion == Frezzer_Transfomation_Enum.FORMA_FINAL) {
	        dano = base + 300;
	    } else { // GOLDEN
	        dano = base + 600;
	    }
	
	    // Cada ataque gasta ki según la forma también:
	    double costeKiAtaque;
	    switch (transformacion) {
	        case PRIMERA_FORMA:
	            costeKiAtaque = 50;
	            break;
	        case SEGUNDA_FORMA:
	            costeKiAtaque = 80;
	            break;
	        case TERCERA_FORMA:
	            costeKiAtaque = 120;
	            break;
	        case FORMA_FINAL:
	            costeKiAtaque = 200;
	            break;
	        case GOLDEN_FREEZER:
	        default:
	            costeKiAtaque = 300;
	            break;
	    }
	
	    if (ki < costeKiAtaque) {
	        System.out.println("No tienes ki suficiente para atacar en esta forma.");
	        return 0;
	    }
	
	    perderKi(costeKiAtaque*0.50);
	    System.out.println("Freezer ataca en " + transformacion + " causando " + dano +
	            " puntos de daño. Ki restante: " + ki);
	    return dano;
	}
	
	/**
	 * Cada unidad de segundo se regenera el Ki a X unidades (HARDCODEADO).
	 */
	public void recargarKi(Integer segundos) {
	    double kiPorSegundo;
	
	    if (transformacion == Frezzer_Transfomation_Enum.PRIMERA_FORMA) {
	        kiPorSegundo = 50;
	    } else if (transformacion == Frezzer_Transfomation_Enum.SEGUNDA_FORMA) {
	        kiPorSegundo = 80;
	    } else if (transformacion == Frezzer_Transfomation_Enum.TERCERA_FORMA) {
	        kiPorSegundo = 120;
	    } else if (transformacion == Frezzer_Transfomation_Enum.FORMA_FINAL) {
	        kiPorSegundo = 180;
	    } else { // GOLDEN
	        kiPorSegundo = 250;
	    }
	
	    this.ki += kiPorSegundo * segundos;
	    System.out.println("Recargando ki durante " + segundos + "s. Nuevo Ki: " + ki);
	}
	
	public void perderKi(Double kiPerdido) {
	    Double total = this.ki - kiPerdido;
	    if (total < 10) { // Mínimo Ki que se deja
	        this.ki = 10.;
	    } else {
	        this.ki = total;
	    }
	}
	
	
	/**
	 * Al defender un ataque, también se pierde una cierta cantidad de ki
	 */
	public void defenderAtaque(Double puntosDePoder) {
	    // No depende de la transformación, pero si dependiera la cosa se ensucia aún más
	    perderKi(puntosDePoder * 0.25);
	    System.out.println("Freezer defiende. Ki restante: " + ki);
	}
	
	public Frezzer_Transfomation_Enum getTransformacion() {
	    return transformacion;
	}
}



