package A2_srp_SOLID.service.impl;

import java.util.List;

import A2_srp_SOLID.model.Order;
import A2_srp_SOLID.service.NotificationService;
import A2_srp_SOLID.utiles.EmailClient;

public class NotificationServiceImpl implements NotificationService {

	
	    private final EmailClient email;
	    
	    public NotificationServiceImpl(EmailClient email) { 
	    	this.email = email; 
	    }
	    
	    public void sendOrderConfirmation(Order order) {
	        email.send(order.getCustomerEmail(),
	            "Pedido " + order.getId(),
	            "Gracias por su compra. Total: " + order.getTotal());
	    }

		@Override
		public List<Object> buscarNotificaciones(String idUsuarrio) {
			System.out.println("Soy "+this.getClass());
			//String resultado = (String) this.email.getNotification(idUsuarrio);
			return null;
		}
	
}
