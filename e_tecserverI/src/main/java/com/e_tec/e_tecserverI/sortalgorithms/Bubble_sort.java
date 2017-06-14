package com.e_tec.e_tecserverI.sortalgorithms;

public class Bubble_sort {

	public static int[] sortInteger(int A[]) {
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
	
	public static String[] sortString(String[] list) {
		String temp;

		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j].compareTo(list[(j + 1)]) > 0) {
					temp = list[j];
					list[j + 1] = list[j];
					list[j] = temp;
				}
			}
		}
		
		return list;

	}
}
