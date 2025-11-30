package despues.sort.impl;

import despues.sort.SortStrategy;
import despues.utils.SortUtils;

public class QuickSort implements SortStrategy {

	@Override
	public void sort(Integer[] numeros) {
		 if (numeros == null || numeros.length < 2) {
	            return;
	        }
	     doQuickSort(numeros, 0, numeros.length - 1);
	}

	 private void doQuickSort(Integer[] array, int left, int right) {
	        if (left < right) {
	            int pivot = randomPartition(array, left, right);
	            doQuickSort(array, left, pivot - 1);
	            doQuickSort(array, pivot, right);
	        }
	    }

    private int randomPartition(Integer[] array, int left, int right) {
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        SortUtils.swap(array, randomIndex, right);
        return partition(array, left, right);
    }

    private int partition(Integer[] array, int left, int right) {
        int mid = (left + right) >>> 1;
        Integer pivot = array[mid];

        while (left <= right) {
            while (SortUtils.less(array[left], pivot)) {
                ++left;
            }
            while (SortUtils.less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                SortUtils.swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }
}
