package com.e_tec.e_tecserverI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.e_tec.e_tecserverI.database.DataBaseClass;
import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.sortalgorithms.SortMaster;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterProduct;

public class ProductService {

	private static Map<Integer, Product> productList = DataBaseClass.getProductList();

	public ProductService() {
		
	}

	public List<Product> getAllProduct() {
		return new ArrayList<Product>(productList.values());
	}

	public List<Product> getSortProductInt(final String sort, final boolean AorD) {		

		return SortMaster.getSortProductInt(sort, getArrayPrice(), AorD);
	}
	
	public List<Product> getSortProductString(final String sort, final boolean AorD) {		

		return SortMaster.getSortProductString(sort, getArrayName(), AorD);
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

	private int[] getArrayPrice() {
		int[] aux = new int[productList.size()];
		ArrayList<Product> products = new ArrayList<Product>(productList.values());

		for (int i = 0; i < aux.length; i++) {
			aux[i] = products.get(i).getPrice();
		}

		return aux;
	}
	
	private String[] getArrayName() {
		String[] aux = new String[productList.size()];
		ArrayList<Product> products = new ArrayList<Product>(productList.values());

		for (int i = 0; i < aux.length; i++) {
			aux[i] = products.get(i).getName();
		}
		
		return aux;
	}

	public static Map<Integer, Product> getProductList() {
		return productList;
	}		
}
