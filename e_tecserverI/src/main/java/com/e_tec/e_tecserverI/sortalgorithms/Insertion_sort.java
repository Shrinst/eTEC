package com.e_tec.e_tecserverI.sortalgorithms;

public class Insertion_sort {

	public static int[] sortIntegerA(int A[]) {

		int temp;
		for (int i = 1; i < A.length; i++) {
			for (int j = i; j > 0; j--) {
				if (A[j] < A[j - 1]) {
					temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
				}
			}
		}
		return A;
	}
	
	public static int[] sortIntegerD(int A[]) {

		int temp;
		for (int i = 1; i < A.length; i++) {
			for (int j = i; j > 0; j--) {
				if (A[j] > A[j - 1]) {
					temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
				}
			}
		}
		return A;
	}
	
	/////////////////-------------------------------String----------------------////////////////////////////////////////
	public static String[] sortStringA(String[] arr){
		String key;               

		for (int j = 1; j < arr.length; j++){
			key = arr[j];
	    	int i;
	        for (i = j - 1; (i >= 0) && (arr[i].compareTo(key) > 0); i--){
	        	arr[i + 1] = arr[i];
	        }
	        arr[i + 1] = key;    
	    }
		
		return arr;
	}
	
	public static String[] sortStringD(String[] arr){
		String key;               

		for (int j = 1; j < arr.length; j++){
			key = arr[j];
	    	int i;
	        for (i = j - 1; (i >= 0) && (arr[i].compareTo(key) < 0); i--){
	        	arr[i + 1] = arr[i];
	        }
	        arr[i + 1] = key;    
	    }
		
		return arr;
	}
	
}
