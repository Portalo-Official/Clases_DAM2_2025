package A2_srp_SOLID.service.impl;

import A2_srp_SOLID.model.Order;
import A2_srp_SOLID.service.OrderValidator;

public class OrderValidatorImpl implements OrderValidator{

	    public void validate(Order order) {
	        if (order == null || order.getItems().isEmpty())
	            throw new IllegalArgumentException("Pedido vacío");
	        var email = order.getCustomerEmail();
	        if (email == null || !email.contains("@"))
	            throw new IllegalArgumentException("Email inválido");
	    }

}
