package com.e_tec.e_tecserverI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.e_tec.e_tecserverI.database.DataBaseClass;
import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.sortalgorithms.Bubble_sort;
import com.e_tec.e_tecserverI.sortalgorithms.Insertion_sort;
import com.e_tec.e_tecserverI.sortalgorithms.Merge_sort;
import com.e_tec.e_tecserverI.sortalgorithms.Radix_sort;
import com.e_tec.e_tecserverI.sortalgorithms.Selection_sort;
import com.e_tec.e_tecserverI.sortalgorithms.Shell_sort;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterProduct;

public class ProductService {

	private Map<Integer, Product> productList = DataBaseClass.getProductList();

	public ProductService() {
		
	}

	public List<Product> getAllProduct() {
		return new ArrayList<Product>(productList.values());
	}

	public List<Product> getSortProduct(String sort) {
		int[] sortBase = this.sortList(sort);
		List<Product> products = new ArrayList<Product>(productList.values());
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

	public List<Product> getAllProductPerCategory(String category) {
		List<Product> products = new ArrayList<>();
		for (Product product : productList.values()) {
			if (product.getCategory().equals(category)) {
				products.add(product);
			}
		}

		return products;
	}

	public Product getProduct(int key) {
		return productList.get(key);
	}

	public Product addProduct(Product product) {

		if (this.isInList(product.getId())) {
			Product temp = productList.get(product.getId());
			int amount = temp.getAmount();
			temp.setAmount(++amount);
		} else {
			productList.put(product.getId(), product);
		}

		XMLWriterProduct.writeXML(new ArrayList<>(productList.values()));
		return product;
	}

	public Product updateProduct(Product product) {
		if (product.getId() <= 0) {
			return null;
		}

		productList.put(product.getId(), product);
		XMLWriterProduct.writeXML(new ArrayList<>(productList.values()));
		return product;
	}

	public void deleteProduct(int id) {
		if (productList.get(id).getAmount() != 1) {
			Product temp = productList.get(id);
			int amount = temp.getAmount();
			temp.setAmount(--amount);
		} else {
			productList.remove(id);
		}

		XMLWriterProduct.writeXML(new ArrayList<>(productList.values()));
	}

	private boolean isInList(int id) {
		boolean found = false;

		for (Product product : productList.values()) {
			if (product.getId() == id) {
				found = true;
				return found;
			}
		}

		return found;
	}

	private int[] getArray() {
		int[] aux = new int[productList.size()];
		ArrayList<Product> products = new ArrayList<Product>(productList.values());

		for (int i = 0; i < aux.length; i++) {
			aux[i] = products.get(i).getPrice();
		}

		return aux;
	}

	private int[] sortList(String sort) {
		int[] aux = this.getArray();
		int[] result = new int[aux.length];

		switch (sort) {
		case "bubble":
			result = Bubble_sort.bubble(aux);
			break;
		case "insertion":
			result = Insertion_sort.Insertion(aux);
			break;
		case "merge":
			result = Merge_sort.merge(aux);
			break;
		// case "quick":
		// result = Quick_sort.quick(aux);
		// break;
		case "radix":
			result = Radix_sort.radix(aux);
			break;
		case "selection":
			result = Selection_sort.selection(aux);
			break;
		case "shell":
			result = Shell_sort.shell(aux);
			break;
		}
		return result;
	}
}
