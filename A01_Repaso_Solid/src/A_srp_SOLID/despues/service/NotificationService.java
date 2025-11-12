package A_srp_SOLID.despues.service;

import A_srp_SOLID.utiles.EmailClient;
import A_srp_SOLID.utiles.Order;

public class NotificationService {

	
	    private final EmailClient email;
	    
	    public NotificationService(EmailClient email) { 
	    	this.email = email; 
	    }
	    
	    public void sendOrderConfirmation(Order order) {
	        email.send(order.getCustomerEmail(),
	            "Pedido " + order.getId(),
	            "Gracias por su compra. Total: " + order.getTotal());
	    }


	
}
