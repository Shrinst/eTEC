package com.e_tec.e_tecserverI.sortalgorithms;

import java.util.ArrayList;
import java.util.List;

import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.service.ProductService;

public class SortMaster {

	private static ArrayList<Product> productList = new ArrayList<Product>(ProductService.getProductList().values());

	public static List<Product> getSortProductInt(String sort, int[] array, boolean AorD) {
		int[] sortBase = getBaseArrayInteger(sort, array, AorD);
		List<Product> products = new ArrayList<Product>(productList);
		ArrayList<Product> sortedProducts = new ArrayList<>();
		
		for (int i = 0; i < sortBase.length; i++) {
			for (int j = 0; j < sortBase.length; j++) {
				if (sortBase[i] == products.get(j).getPrice()) {
					sortedProducts.add(products.get(j));
					break;
				}
			}
		}

		return sortedProducts;
	}
	
	public static List<Product> getSortProductString(String sort, String[] array, boolean AorD) {
		String[] sortBase = getBaseArrayString(sort, array, AorD);
		List<Product> products = new ArrayList<Product>(productList);
		ArrayList<Product> sortedProducts = new ArrayList<>();	
		
		for (int i = 0; i < sortBase.length; i++) {
			for (int j = 0; j < sortBase.length; j++) {			
				
				if (sortBase[i].equals(products.get(j).getName())) {
					sortedProducts.add(products.get(j));
					break;
				}
			}
		}

		return sortedProducts;
	}

	private static int[] getBaseArrayInteger(String sort, int[] array, boolean AorD) {
		int[] aux = new int[array.length];
		// true for ascendant, false for descendant;
		if (AorD) {
			aux = sortListIntegerA(sort, array);
		} else {
			aux = sortListIntegerD(sort, array);
		}

		return aux;
	}	

	private static int[] sortListIntegerA(String sort, int[] array) {
		int[] aux = array;
		int[] result = new int[aux.length];

		switch (sort) {
		case "bubble":
			result = Bubble_sort.sortIntegerA(aux);
			break;
		case "insertion":
			result = Insertion_sort.sortIntegerD(aux);
			break;
		case "merge":
			result = Merge_sort.sortIntegerA(aux);
			break;
		 case "quick":
			 result = Quick_sort.sortIntegerA(aux);
		 break;
		case "radix":
			result = Radix_sort.radix(aux);
			break;
		case "selection":
			result = Selection_sort.sortIntegerA(aux);
			break;
		case "shell":
			result = Shell_sort.sortIntegerA(aux);
			break;
		}
		return result;
	}
	
	private static int[] sortListIntegerD(String sort, int[] array) {
		int[] aux = array;
		int[] result = new int[aux.length];

		switch (sort) {
		case "bubble":
			result = Bubble_sort.sortIntegerD(aux);
			break;	
		case "insertion":
			result = Insertion_sort.sortIntegerD(aux);
			break;
		case "merge":
			result = Merge_sort.sortIntegerD(aux);
			break;
		case "selection":
			result = Selection_sort.sortIntegerD(aux);
			break;
		case "shell":
			result = Selection_sort.sortIntegerD(aux);
			break;
		}
		return result;
	}
	
	///////////////////////---------------------String------------------------------------////////////////////////////////
	
	private static String[] getBaseArrayString(String sort, String[] array, boolean AorD) {
		String aux[] = new String[array.length];
		
		if (AorD) {
			aux = sortListStringA(sort, array);
		} else {
			aux = sortListStringD(sort, array);
		}

		return aux;
	}
	
	private static String[] sortListStringA(String sort, String[] array) {
		String[] aux = array;
		String[] result = new String[aux.length];

		switch (sort) {
		case "bubble":
			result = Bubble_sort.sortStringA(aux);
			break;
		case "selection":
			result = Selection_sort.sortStringA(aux);
			break;
		case "insertion":
			result = Insertion_sort.sortStringA(aux);
			break;
		case "merge":
			result = Merge_sort.sortStringA(aux);
			break;
		case "quick":
			result = Quick_sort.sortStringA(aux);
			break;
		case "shell":
			result = Shell_sort.sortStringA(aux);
			break;
		}
		
		return result;
	}
	
	private static String[] sortListStringD(String sort, String[] array) {
		String[] aux = array;
		String[] result = new String[aux.length];

		switch (sort) {
		case "shell":
			result = Shell_sort.sortStringD(aux);
			break;
		case "selection":
			result = Selection_sort.sortStringD(aux);
			break;
		case "quick":
			result = Quick_sort.sortStringD(aux);
			break;
		case "merge":
			result = Merge_sort.sortStringD(aux);
			break;
		case "insertion":
			result = Insertion_sort.sortStringD(aux);
			break;
		case "bubble":
			result = Bubble_sort.sortStringD(aux);
			break;
		}
		
		return result;
	}	
}
