package A2_srp_SOLID.service.impl;

import A2_srp_SOLID.model.Order;
import A2_srp_SOLID.service.PricingService;

public class PricingServiceImpl implements PricingService{


    public void price(Order order) {
	        double subtotal = order.getItems().stream()
	            .mapToDouble(i -> i.getUnitPrice() * i.getQty()).sum();
	        double discount = subtotal > 100 ? subtotal * 0.05 : 0.0;
	        double taxes = (subtotal - discount) * 0.21;
	        double total = subtotal - discount + taxes;
	        order.setTotals(subtotal, discount, taxes, total);
	    }
	
}
