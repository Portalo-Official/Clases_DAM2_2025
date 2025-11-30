package despues.sort.impl;

import despues.sort.SortStrategy;

public class CountingSort implements SortStrategy {

	@Override
	public void sort(Integer[] numeros) {
		if (numeros == null || numeros.length < 2) {
            return;
        }

        // 1. Encontrar mínimo y máximo
        int min = numeros[0];
        int max = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            int v = numeros[i];
            if (v < min) {
                min = v;
            }
            if (v > max) {
                max = v;
            }
        }

        int range = max - min + 1;   // tamaño del array de contadores

        // 2. Array de frecuencias
        int[] count = new int[range];
        for (int i = 0; i < numeros.length; i++) {
            int v = numeros[i];
            count[v - min]++;        // desplazamiento por min para soportar negativos
        }

        // 3. Prefijos acumulados
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // 4. Construir array de salida (recorremos de derecha a izquierda para estabilidad)
        Integer[] output = new Integer[numeros.length];
        for (int i = numeros.length - 1; i >= 0; i--) {
            int v = numeros[i];
            int idx = v - min;
            int pos = --count[idx];
            output[pos] = v;
        }

        // 5. Copiar resultado al array original
        System.arraycopy(output, 0, numeros, 0, numeros.length);
		
	}

    
}
