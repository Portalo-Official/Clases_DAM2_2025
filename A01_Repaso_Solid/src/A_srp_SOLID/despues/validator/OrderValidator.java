package A_srp_SOLID.despues.validator;

import A_srp_SOLID.utiles.Order;

public class OrderValidator {

	    public void validate(Order order) {
	        if (order == null || order.getItems().isEmpty())
	            throw new IllegalArgumentException("Pedido vacío");
	        var email = order.getCustomerEmail();
	        if (email == null || !email.contains("@"))
	            throw new IllegalArgumentException("Email inválido");
	    }

}
