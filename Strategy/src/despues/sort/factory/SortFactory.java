package despues.sort.factory;

import antes.SortConstans;
import despues.sort.SortStrategy;
import despues.sort.impl.BubbleSort;
import despues.sort.impl.CountingSort;
import despues.sort.impl.QuickSort;

public class SortFactory {

	   public static SortStrategy createSortStrategy(String tipoOrdenacion) {

		   SortStrategy sortAlgorithm;

	        if (SortConstans.BUBBLE_SORT.equals(tipoOrdenacion)) {
	            sortAlgorithm = new BubbleSort();
	        } else if (SortConstans.QUICK_SORT.equals(tipoOrdenacion)) {
	            sortAlgorithm = new QuickSort();
	        } else if(SortConstans.COUNTING_SORT.equals(tipoOrdenacion)){
	            sortAlgorithm = new CountingSort();
	        }else {
	        	throw new IllegalArgumentException("El tipo de Ordenación: '"+tipoOrdenacion+"' no es valido");
	        }

	        return sortAlgorithm;
	    }
}
