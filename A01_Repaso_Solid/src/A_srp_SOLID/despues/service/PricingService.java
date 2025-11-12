package A_srp_SOLID.despues.service;

import A_srp_SOLID.utiles.Order;

public class PricingService {


    public void price(Order order) {
	        double subtotal = order.getItems().stream()
	            .mapToDouble(i -> i.getUnitPrice() * i.getQty()).sum();
	        double discount = subtotal > 100 ? subtotal * 0.05 : 0.0;
	        double taxes = (subtotal - discount) * 0.21;
	        double total = subtotal - discount + taxes;
	        order.setTotals(subtotal, discount, taxes, total);
	    }
	
}
