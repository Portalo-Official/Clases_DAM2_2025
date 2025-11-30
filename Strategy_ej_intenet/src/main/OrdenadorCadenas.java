package main;

import sort.SortAlgorithm;
import sort.factorry.SortAlgorithmSimpleFactory;

public class OrdenadorCadenas {

	
    private SortAlgorithm sortAlgorithm;

    public String[] ordena(String[] arregloDesordenado) {

        sortAlgorithm = SortAlgorithmSimpleFactory.getSortingAlgorithm(arregloDesordenado.length);

        String[] arregloOrdenado = sortAlgorithm.sort(arregloDesordenado);

        return arregloOrdenado;
    }
}
