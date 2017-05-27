package com.e_tec.e_tecserverI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.e_tec.e_tecserverI.database.DataBaseClass;
import com.e_tec.e_tecserverI.model.Product;

public class ProductService {

	private Map<Integer, Product> productList = DataBaseClass.getProductList();

	public ProductService() {
		productList.put(124222, new Product("VideoGame", "hfhsfs", 124222, "hgogjeg"));
		productList.put(25253, new Product("PS4", "NFJBJGG", 25253, "FJDBGB"));
		productList.put(24253, new Product("PS4", "NFJBJGG", 24253, "FJDBGB"));
	}

	public List<Product> getAllProduct() {
		return new ArrayList<Product>(productList.values());
	}

	public Product getProduct(int key) {
		return productList.get(key);
	}

	public Product addProduct(Product product) {
		productList.put(product.getId(), product);
		return product;
	}

	public Product updateProduct(Product product) {
		if (product.getId() <= 0) {
			return null;
		}

		productList.put(product.getId(), product);
		return product;
	}

	public void deleteProduct(int id) {
		productList.remove(id);
	}
}
