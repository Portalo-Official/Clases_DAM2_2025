package A2_srp_SOLID.model;

public class OrderItem {

	private int precioUnidad;
	private int cantidad;
	
	public int getUnitPrice() {
		// TODO Auto-generated method stub
		return this.precioUnidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getQty() {
		// TODO Auto-generated method stub
		return 0;
	}

}
