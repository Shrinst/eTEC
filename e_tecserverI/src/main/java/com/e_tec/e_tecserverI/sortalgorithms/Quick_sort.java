package com.e_tec.e_tecserverI.sortalgorithms;

public class Quick_sort {

	public static int[] sortIntegerA(int A[]) {

		return quickSort(A, 0, A.length - 1);

	}

	public static int[] quickSort(int vec[], int inicio, int fin) {
		if (inicio >= fin)
			return null;
		int pivote = vec[inicio];
		int elemIzq = inicio + 1;
		int elemDer = fin;
		while (elemIzq <= elemDer) {
			while (elemIzq <= fin && vec[elemIzq] < pivote) {
				elemIzq++;
			}
			while (elemDer > inicio && vec[elemDer] >= pivote) {
				elemDer--;
			}
			if (elemIzq < elemDer) {
				int temp = vec[elemIzq];
				vec[elemIzq] = vec[elemDer];
				vec[elemDer] = temp;
			}
		}

		if (elemDer > inicio) {
			int temp = vec[inicio];
			vec[inicio] = vec[elemDer];// swap
			vec[elemDer] = temp;
		}
		quickSort(vec, inicio, elemDer - 1);
		quickSort(vec, elemDer + 1, fin);
		return vec;
	}
	
	///////////////////////--------------------------String-------------------------///////////////////////////////
	public static String[] sortStringA(String[] arr){

		int low = 0;
		int high = arr.length - 1;
 
		qSortA(arr, low, high);
		
		return arr;
    }

	private static void qSortA(String[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		String pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i].compareTo(pivot) < 0) {
				i++;
			}
 
			while (arr[j].compareTo(pivot) > 0) {
				j--;
			}
 
			if (i <= j) {
				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			qSortA(arr, low, j);
 
		if (high > i)
			qSortA(arr, i, high);
	}
	
	public static String[] sortStringD(String[] arr){

		int low = 0;
		int high = arr.length - 1;
 
		qSortB(arr, low, high);
		
		return arr;
    }

	private static void qSortB(String[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		String pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i].compareTo(pivot) > 0) {
				i++;
			}
 
			while (arr[j].compareTo(pivot) < 0) {
				j--;
			}
 
			if (i <= j) {
				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			qSortB(arr, low, j);
 
		if (high > i)
			qSortB(arr, i, high);
	}	
   
}
