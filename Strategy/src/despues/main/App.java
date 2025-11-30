package despues.main;

import java.util.Arrays;

import despues.model.ListaNumeros;
import despues.sort.SortStrategy;
import despues.sort.factory.SortFactory;
import despues.utils.SortConstans;

public class App {

	public static void main(String[] args) {
		
		Integer[] numeros = {6, 45, 76, 453, 6547,2, 4, 345,5, 7, 1, 8, 9, 10};
		
		String tipoSort = SortConstans.BUBBLE_SORT; //COUNTING_SORT, QUICK_SORT,  BUBBLE_SORT
		
		// Creamos Strategy
		SortStrategy sortStrategy = SortFactory.createSortStrategy(tipoSort);
		
		// Inyectamos strategy desde fuera desde constructor
		ListaNumeros listaNumeros = new ListaNumeros(numeros, sortStrategy);
		
		
		
		
		
		System.out.println("Sin Ordenar");
		System.out.println(Arrays.toString(listaNumeros.getNumeros()));
		
		listaNumeros.sort();
		System.out.println("Ordenado");
		
		System.out.println(Arrays.toString(listaNumeros.getNumeros()));

	}

}
