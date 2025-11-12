package app;

import alerta.Alerta;
import alerta.impl.AlertaCritica;
import alerta.impl.AlertaInformativa;
import canal.impl.EmailCanal;
import canal.impl.PushCanal;
import canal.impl.SMSCanal;

public class App {

	 public static void main(String[] args) {
		 
	        Alerta a1 = new AlertaCritica(new SMSCanal());
	        Alerta a2 = new AlertaInformativa(new EmailCanal());
	        Alerta a3 = new AlertaCritica(new PushCanal());

	        a1.notificar("CPU > 95% durante 5 min");
	        
	        a2.notificar("Backup nocturno completado");
	        
	        a3.notificar("Base de datos sin réplicas disponibles");
	    }
}
