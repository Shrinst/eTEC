package com.e_tec.e_tecserverI.sortalgorithms;

public class Selection_sort {

	public static int[] selection(int A[]) {
		int menor, temp;
		int pos;
		for (int i = 0; i < A.length - 1; i++) { // tomamos como menor el
													// primero
			menor = A[i]; // de los elementos que quedan por ordenar
			pos = i; // y guardamos su posici�n
			for (int j = i + 1; j < A.length; j++) { // buscamos en el resto
				if (A[j] < menor) { // del array alg�n elemento
					menor = A[j]; // menor que el actual
					pos = j;
				}
			}
			if (pos != i) { // si hay alguno menor se intercambia
				temp = A[i];
				A[i] = A[pos];
				A[pos] = temp;
			}
		}
		return A;
	}

}
