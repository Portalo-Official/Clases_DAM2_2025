package a05_comsumer_producto.recurso;

public interface Cinteable {

	void addProducto(String producto) throws InterruptedException;

	String cogerProducto() throws InterruptedException;

	boolean estaVacia();
	public boolean estaLlena();

}