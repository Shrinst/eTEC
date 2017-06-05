package com.e_tec.e_tecserverI.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.xml.parser.XMLParserProduct;

public class DataBaseClass {
	
	private static Map<Integer, Product> productList = new HashMap<>();
    private static Map<String, Client> clientList = new HashMap<>();

    public DataBaseClass() {
    }
    
    @XmlTransient
    public static Map<Integer, Product> getProductList() {
    	List<Product> products = XMLParserProduct.getNodes();
    	for (Product product : products) {
    		productList.put(product.getId(), product);
    	}
        return productList;
    } 
    
    public static Map<String, Client> getClientList() {
        return clientList;
    }
}
