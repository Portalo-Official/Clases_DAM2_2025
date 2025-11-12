package A2_srp_SOLID.model;

import java.util.List;

public class Order {
	private String id;
	List<OrderItem> items;
	private int total;
	
	public List<OrderItem> getItems() {
		// TODO Auto-generated method stub
		return this.items;
	}

	public String getCustomerEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTotals(double subtotal, double discount, double taxes, double total) {
		// TODO Auto-generated method stub
		
	}

	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public double getTotal() {
		// TODO Auto-generated method stub
		return this.total;
	}

}
