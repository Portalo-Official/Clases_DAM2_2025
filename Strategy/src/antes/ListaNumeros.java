package antes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class ListaNumeros {

	private Integer[] numeros;

	public ListaNumeros(Integer[] numeros) {
		super();
		this.numeros = numeros;
	}
	
	public ListaNumeros() {
		super();
		this.numeros = new Integer[3000];
	}

	public Integer[] getNumeros() {
		return numeros;
	}
	
	public Integer[] sort(String tipoOrdenacion) {
		
		if(SortConstans.BUBBLE_SORT.equalsIgnoreCase(tipoOrdenacion)) {
			 // ===== BUBBLE SORT   =========================================================
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
			
		}else if(SortConstans.QUICK_SORT.equalsIgnoreCase(tipoOrdenacion)) {
	        
			 // ===== QUICK SORT   =========================================================
            if (numeros != null && numeros.length > 1) {

                int n = numeros.length;
                int[] leftStack = new int[n];
                int[] rightStack = new int[n];
                int top = -1;

                leftStack[++top] = 0;
                rightStack[top] = n - 1;

                while (top >= 0) {
                    int low = leftStack[top];
                    int high = rightStack[top];
                    top--;

                    // Partición tipo Lomuto
                    Integer pivot = numeros[high];
                    int i = low - 1;

                    for (int j = low; j < high; j++) {
                        // numeros[j] <= pivot → !greater(numeros[j], pivot)
                        if (!SortUtils.greater(numeros[j], pivot)) {
                            i++;
                            SortUtils.swap(numeros, i, j);
                        }
                    }
                    SortUtils.swap(numeros, i + 1, high);
                    int pivotIndex = i + 1;

                    // Rango izquierdo
                    if (pivotIndex - 1 > low) {
                        leftStack[++top] = low;
                        rightStack[top] = pivotIndex - 1;
                    }

                    // Rango derecho
                    if (pivotIndex + 1 < high) {
                        leftStack[++top] = pivotIndex + 1;
                        rightStack[top] = high;
                    }
                }
            }

			
		}else if(SortConstans.COUNTING_SORT.equalsIgnoreCase(tipoOrdenacion)) {
			
			// ===== COUNTING SORT   =========================================================
            if (numeros != null && numeros.length > 1) {

                // 1. Encontrar mínimo y máximo usando SortUtils.less / greater
                Integer min = numeros[0];
                Integer max = numeros[0];

                for (int i = 1; i < numeros.length; i++) {
                    Integer v = numeros[i];
                    if (SortUtils.less(v, min)) {
                        min = v;
                    } else if (SortUtils.greater(v, max)) {
                        max = v;
                    }
                }

                int range = max - min + 1; // autounboxing

                // 2. Array de frecuencias
                int[] count = new int[range];
                for (int i = 0; i < numeros.length; i++) {
                    int idx = numeros[i] - min;
                    count[idx]++;
                }

                // 3. Prefijos acumulados
                for (int i = 1; i < range; i++) {
                    count[i] += count[i - 1];
                }

                // 4. Construir array de salida (recorrido inverso para estabilidad)
                Integer[] output = new Integer[numeros.length];
                for (int i = numeros.length - 1; i >= 0; i--) {
                    int v = numeros[i];
                    int idx = v - min;
                    int pos = --count[idx];
                    output[pos] = v;
                }

                // 5. Copiar resultado a 'numeros'
                for (int i = 0; i < numeros.length; i++) {
                    numeros[i] = output[i];
                }
            }
			
		}else {
			throw new IllegalArgumentException("El tipo de Ordenación: '"+tipoOrdenacion+"' no es valido");
		}
		
		return this.numeros;
	}
	
}
