package sort.factorry;

import sort.SortAlgorithm;
import sort.impl.BubbleSort;
import sort.impl.CountingSort;
import sort.impl.QuickSort;

public class SortAlgorithmSimpleFactory {

	private static final int ELEMENTOS_BUBBLE_SORT = 5;
    private static final int ELEMENTOS_QUICK_SORT = 10;

    public static SortAlgorithm getSortingAlgorithm(int numeroDeElementos) {

        SortAlgorithm sortAlgorithm;

        if (numeroDeElementos < ELEMENTOS_BUBBLE_SORT) {
            sortAlgorithm = new BubbleSort();
        } else if (numeroDeElementos > ELEMENTOS_BUBBLE_SORT && numeroDeElementos <= ELEMENTOS_QUICK_SORT) {
            sortAlgorithm = new QuickSort();
        } else {
            sortAlgorithm = new CountingSort();
        }

        return sortAlgorithm;
    }
}
