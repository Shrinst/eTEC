package com.e_tec.e_tecserverI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.e_tec.e_tecserverI.database.DataBaseClass;
import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterProduct;

public class ProductService {

	private Map<Integer, Product> productList = DataBaseClass.getProductList();

	public ProductService() {
//		productList.put(12,	new Product("Horizon Zero Dawn", "http://media.vandal.net/m/26118/horizon-zero-dawn-20173114177_1.jpg",
//						12, 1, "VideoJuegos", "hgogjeg"));
//		productList.put(52,	new Product("Parlantes", "http://www.computiendaelectronica.com/wp-content/uploads/2015/08/computienda_electronica_parlantes-2-0-genius-sp-u115-rojos_usb.jpg",
//						52, 1, "AparatosElectrónicos", "FJDBGB"));
//		productList.put(11, new Product("Dell Inspiron 15", "http://i.dell.com/sites/imagecontent/products/PublishingImages/inspiron-15-5551-5552-5558-laptop/laptop-inspiron-15-5000-polaris-mag-pdp-module-2.jpg", 
//						12, 1, "AparatosElectrónicos", "hgogjeg"));
//		productList.put(53, new Product("Estufa", "https://s3-us-west-1.amazonaws.com/whirlpool-cdn/wp-content/uploads/2016/06/wf5151d.png",
//						53, 1, "Electrodomesticos", "FJDBGB"));
	}

	public List<Product> getAllProduct() {
		return new ArrayList<Product>(productList.values());
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
		productList.put(product.getId(), product);
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
		productList.remove(id);

		XMLWriterProduct.writeXML(new ArrayList<>(productList.values()));
	}
}
