package A_srp_SOLID.despues.orquestador;

import java.util.List;

import A2_srp_SOLID.utiles.EmailClient;
import A_srp_SOLID.despues.service.NotificationService;
import A_srp_SOLID.despues.service.NotificationServiceSecurity;

public class EmailProcessor {

	NotificationServiceSecurity emailClient;
	
	public Object enviarNotificacion() {
		
		 emailClient.sendOrderConfirmation(null); //EmailSecurrity 
		
		
		return null;	
	}
	
}
