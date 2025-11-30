package despues.sort.impl;

import despues.sort.SortStrategy;
import despues.utils.SortUtils;

public class BubbleSort implements SortStrategy {

	@Override
	public void sort(Integer[] numeros) {
        if (numeros == null || numeros.length < 2) {
            return;
        }

        for (int i = 1, size = numeros.length; i < size; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - i; ++j) {
                if (SortUtils.greater(numeros[j], numeros[j + 1])) {
                    SortUtils.swap(numeros, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
		
	}



}
