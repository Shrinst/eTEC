package com.e_tec.e_tecserverI.sortalgorithms;

public class Insertion_sort {

	public static int[] Insertion(int A[]) {

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

}
