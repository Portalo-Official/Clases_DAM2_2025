package A2_srp_SOLID.service;

import java.util.List;

import A2_srp_SOLID.model.Order;

public interface NotificationService {
	    
	    public void sendOrderConfirmation(Order order);
	    
	    public List<Object> buscarNotificaciones(String idUsuarrio);
	    
}
