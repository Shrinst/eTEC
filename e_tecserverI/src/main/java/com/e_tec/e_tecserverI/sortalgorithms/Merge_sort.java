package com.e_tec.e_tecserverI.sortalgorithms;

public class Merge_sort {

	public static int[] merge(int A[]) {

		return merge_sort(A, 0, A.length - 1);

	}

	private static int[] merge_sort(int A[], int izq, int der) {
		if (izq < der) {
			int m = (izq + der) / 2;
			merge_sort(A, izq, m);
			merge_sort(A, m + 1, der);
			merge(A, izq, m, der);
		}
		return A;
	}

	private static void merge(int A[], int izq, int m, int der) {
		int i, j, k;
		int[] B = new int[A.length]; // array auxiliar
		for (i = izq; i <= der; i++) // copia ambas mitades en el array auxiliar
			B[i] = A[i];

		i = izq;
		j = m + 1;
		k = izq;
		while (i <= m && j <= der) // copia el siguiente elemento m�s grande
			if (B[i] <= B[j])
				A[k++] = B[i++];
			else
				A[k++] = B[j++];
		while (i <= m) // copia los elementos que quedan de la
			A[k++] = B[i++]; // primera mitad (si los hay)
	}

}
