package practicando;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Shein implements Publisher<Comprador, Producto>{
	private Producto producto;
	private List<Comprador> compradores;
	private PropertyChangeSupport ps = new PropertyChangeSupport(this);
	
	
	public Shein(Producto producto, List<Comprador> compradores) {
		super();
		this.producto = producto;
		this.compradores = compradores;
	}
	
	public Shein(Producto producto) {
		super();
		this.producto = producto;
		this.compradores = new ArrayList<>();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void nuevoStock(int cantidad) {
		Producto productoOld = new Producto(this.producto.getNombre());
		productoOld.setCantidad(this.producto.getCantidad());
		
		producto.setCantidad(cantidad);
		
		notifySubscriber(productoOld, this.producto);
	}

	@Override
	public boolean subscribe(Comprador t) {
		ps.addPropertyChangeListener(t);
		return false;
	}

	@Override
	public boolean unsubscriber(Comprador t) {
		ps.removePropertyChangeListener(t);
		return false;
		
	}


	@Override
	public void notifySubscriber(Producto kAntigua, Producto kNueva) {
		ps.firePropertyChange("San Jeronimo", kAntigua, kNueva);

	}
	
	
	
}
