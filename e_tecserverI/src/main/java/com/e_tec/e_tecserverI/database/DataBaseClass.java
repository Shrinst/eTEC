package com.e_tec.e_tecserverI.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.model.DistributionCenter;
import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.model.Package;
import com.e_tec.e_tecserverI.xml.parser.XMLParserClient;
import com.e_tec.e_tecserverI.xml.parser.XMLParserDistributionCenter;
import com.e_tec.e_tecserverI.xml.parser.XMLParserPackage;
import com.e_tec.e_tecserverI.xml.parser.XMLParserProduct;

public class DataBaseClass {
	
	private static Map<Integer, Product> productList = new HashMap<>();
    private static Map<String, Client> clientList = new HashMap<>();  
    private static Map<Integer, Package> packageList = new HashMap<>();
    private static Map<String, DistributionCenter> distributionList = new HashMap<>();
    
    public static Map<Integer, Product> getProductList() {
    	List<Product> products = XMLParserProduct.getNodes();
    	for (Product product : products) {
    		productList.put(product.getId(), product);
    	}
        return productList;
    } 
    
    public static Map<String, Client> getClientList() {
    	List<Client> clients = XMLParserClient.getNodes();
    	for (Client client : clients) {
    		clientList.put(client.getName(), client);
    	}
        return clientList;
    }
    
    public static Map<Integer, Package> getPackageList() {
    	List<Package> packages = XMLParserPackage.getNodes();
    	for (Package package1 : packages) {
    		packageList.put(package1.getCode(), package1);
    	}
    	return packageList;
    }
    
    public static Map<String, DistributionCenter> getDistributionList() {
    	List<DistributionCenter> distributionCenters = XMLParserDistributionCenter.getNodes();
    	for (DistributionCenter center : distributionCenters) {
    		distributionList.put(center.getName(), center);
    	}
    	return distributionList;
    }
}
