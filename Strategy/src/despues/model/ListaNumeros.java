package despues.model;

import despues.sort.SortStrategy;


public class ListaNumeros {

	private Integer[] numeros;
	private SortStrategy sortStrategy;

	public ListaNumeros(Integer[] numeros, SortStrategy sortStrategy) {
		super();
		this.numeros = numeros;
		this.sortStrategy = sortStrategy;
	}

	public Integer[] getNumeros() {
		return numeros;
	}
	
	public Integer[] sort() {
		
		this.sortStrategy.sort(numeros);
		
		return this.numeros;
	}
	
	public void cambiarComportamiento(SortStrategy sortStrategy) {
		this.sortStrategy = sortStrategy;
	}
}
