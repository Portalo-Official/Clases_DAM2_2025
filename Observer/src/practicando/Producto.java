package practicando;

public class Producto {
	private String nombre;
	private int cantidad;
	
	public Producto(String nombre) {
		super();
		this.nombre = nombre;
		this.cantidad = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}
	
	
	
}
