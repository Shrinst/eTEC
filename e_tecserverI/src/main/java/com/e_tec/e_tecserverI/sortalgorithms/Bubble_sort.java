package com.e_tec.e_tecserverI.sortalgorithms;

public class Bubble_sort {

	public static int[] sortIntegerA(int A[]) {
		int i, j;
		int aux;
		for (i = 0; i < A.length - 1; i++)
			for (j = 0; j < A.length - i - 1; j++)
				if (A[j + 1] < A[j]) {
					aux = A[j + 1];
					A[j + 1] = A[j];
					A[j] = aux;
				}
		return A;
	}
	
	public static int[] sortIntegerD(int A[]) {
		int i, j;
		int aux;
		for (i = 0; i < A.length - 1; i++)
			for (j = 0; i < A.length - j - 1; j++)
				if (A[j + 1] > A[j]) {
					aux = A[j + 1];
					A[j + 1] = A[j];
					A[j] = aux;
				}
		return A;
	}	
	
	////////////////////////////////////-----------------String----------------------/////////////////////////////////
	public static String[] sortStringA(String[] arr) {

	    int n = arr.length;
	    String temp = null;

	    for (int i = 0; i < n; i++) {
	        for (int j = 1; j < (n - i); j++) {

	            if (arr[j - 1].compareTo(arr[j]) > 0) {
	                temp = arr[j - 1];
	                arr[j - 1] = arr[j];
	                arr[j] = temp;
	            }

	        }
	    }	
	    
	    return arr;
	}
	
	public static String[] sortStringD(String[] arr) {

	    int n = arr.length;
	    String temp = null;

	    for (int i = 0; i < n; i++) {
	        for (int j = 1; j < (n - i); j++) {

	            if (arr[j - 1].compareTo(arr[j]) < 0) {
	                temp = arr[j - 1];
	                arr[j - 1] = arr[j];
	                arr[j] = temp;
	            }

	        }
	    }
	    
	    return arr;
	}
	
}
