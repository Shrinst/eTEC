package com.e_tec.e_tecserverI.sortalgorithms;

public class Shell_sort {

	public static int[] sortIntegerA(int A[]) {
		int salto, i;
		int aux;
		boolean cambios;
		for (salto = A.length / 2; salto != 0; salto /= 2) {
			cambios = true;
			while (cambios) { // Mientras se intercambie alg�n elemento
				cambios = false;
				for (i = salto; i < A.length; i++) // se da una pasada
					if (A[i - salto] > A[i]) { // y si est�n
												// desordenados
						aux = A[i]; // se reordenan
						A[i] = A[i - salto];
						A[i - salto] = aux;
						cambios = true; // y se marca como cambio.
					}
			}
		}
		return A;
	}
	
	public static int[] sortIntegerD(int A[]) {
		int salto, i;
		int aux;
		boolean cambios;
		for (salto = A.length / 2; salto != 0; salto /= 2) {
			cambios = true;
			while (cambios) { // Mientras se intercambie alg�n elemento
				cambios = false;
				for (i = salto; i < A.length; i++) // se da una pasada
					if (A[i - salto] < A[i]) { // y si est�n
												// desordenados
						aux = A[i]; // se reordenan
						A[i] = A[i - salto];
						A[i - salto] = aux;
						cambios = true; // y se marca como cambio.
					}
			}
		}
		return A;
	}
	
	////////////////////////////////---------------String-------------------------//////////////////////////////////
	public static String[] sortStringA(String[] arr) {
		int inner, outer;
	    String temp;
	 
	    int h = 1;
	    while (h <= arr.length / 3) {
	      h = h * 3 + 1;
	    }
	    
	    while (h > 0) {
	    	for (outer = h; outer < arr.length; outer++) {
	    		temp = arr[outer];
	    		inner = outer;
	 
	    		while (inner > h - 1 && arr[inner - h].compareTo(temp) >= 0) {
	    			arr[inner] = arr[inner - h];
	    			inner -= h;
	    		}
	    		arr[inner] = temp;
	    	}
	      h = (h - 1) / 3;
	    }
	    
	    return arr;
	}
	
	public static String[] sortStringD(String[] arr) {
		int inner, outer;
	    String temp;
	 
	    int h = 1;
	    while (h <= arr.length / 3) {
	      h = h * 3 + 1;
	    }
	    
	    while (h > 0) {
	    	for (outer = h; outer < arr.length; outer++) {
	    		temp = arr[outer];
	    		inner = outer;
	 
	    		while (inner > h - 1 && arr[inner - h].compareTo(temp) <= 0) {
	    			arr[inner] = arr[inner - h];
	    			inner -= h;
	    		}
	    		arr[inner] = temp;
	    	}
	      h = (h - 1) / 3;
	    }
	    
	    return arr;
	}
	
}
