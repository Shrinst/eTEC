package com.e_tec.e_tecserverI.sortalgorithms;

public class Selection_sort {

	public static int[] sortIntegerA(int A[]) {
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

	public static int[] sortIntegerD(int A[]) {
		int menor, temp;
		int pos;
		for (int i = 0; i < A.length - 1; i++) { // tomamos como menor el
													// primero
			menor = A[i]; // de los elementos que quedan por ordenar
			pos = i; // y guardamos su posici�n
			for (int j = i + 1; j < A.length; j++) { // buscamos en el resto
				if (A[j] > menor) { // del array alg�n elemento
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

	/////////////// ----------------String---------------------------//////////////////////////////////////
	public static String[] sortStringA(String[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j].compareTo(arr[index]) < 0)
					index = j;

			String smaller = arr[index];
			arr[index] = arr[i];
			arr[i] = smaller;
		}

		return arr;
	}

	public static String[] sortStringD(String[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j].compareTo(arr[index]) > 0) {
					index = j;
				}
			String bigger = arr[index];
			arr[index] = arr[i];
			arr[i] = bigger;
		}
		
		return arr;
	}

}
