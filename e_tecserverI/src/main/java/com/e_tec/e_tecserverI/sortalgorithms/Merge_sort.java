package com.e_tec.e_tecserverI.sortalgorithms;

public class Merge_sort {

	public static int[] sortIntegerA(int A[]) {

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
	
	public static int[] sortIntegerD(int A[]) {

		return merge_sortD(A, 0, A.length - 1);

	}

	private static int[] merge_sortD(int A[], int izq, int der) {
		if (izq < der) {
			int m = (izq + der) / 2;
			merge_sortD(A, izq, m);
			merge_sortD(A, m + 1, der);
			mergeD(A, izq, m, der);
		}
		return A;
	}

	private static void mergeD(int A[], int izq, int m, int der) {
		int i, j, k;
		int[] B = new int[A.length]; // array auxiliar
		for (i = izq; i <= der; i++) // copia ambas mitades en el array auxiliar
			B[i] = A[i];

		i = izq;
		j = m + 1;
		k = izq;
		while (i <= m && j <= der) // copia el siguiente elemento m�s grande
			if (B[i] >= B[j])
				A[k++] = B[i++];
			else
				A[k++] = B[j++];
		while (i <= m) // copia los elementos que quedan de la
			A[k++] = B[i++]; // primera mitad (si los hay)
	}
	
	
	/////////////////////---------------------------String-----------------------///////////////////////////////
	public static String[] sortStringA(String[] arr) {
        int size = arr.length;
        if (size < 2)
            return null;
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        String[] left = new String[leftSize];
        String[] right = new String[rightSize];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];

        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = arr[i];
        }
        sortStringA(left);
        sortStringA(right);
        merge(left, right, arr);
        
        return arr;
    }
    
    private static void merge(String[] left, String[] right, String[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            arr[k++] = left[i++];
        }
        while (j < leftSize) {
            arr[k++] = right[j++];
        }
    }
    
    public static String[] sortStringD(String[] arr) {
        int size = arr.length;
        if (size < 2)
            return null;
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        String[] left = new String[leftSize];
        String[] right = new String[rightSize];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];

        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = arr[i];
        }
        sortStringD(left);
        sortStringD(right);
        mergeB(left, right, arr);
        
        return arr;
    }
    
    private static void mergeB(String[] left, String[] right, String[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i].compareTo(right[j]) >= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            arr[k++] = left[i++];
        }
        while (j < leftSize) {
            arr[k++] = right[j++];
        }
    }  

}
