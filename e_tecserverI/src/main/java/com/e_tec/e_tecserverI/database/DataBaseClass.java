package com.e_tec.e_tecserverI.database;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.model.Product;

public class DataBaseClass {
	
	private static Map<Integer, Product> productList = new HashMap<>();
    private static Map<String, Client> clientList = new HashMap<>();

    public DataBaseClass() {
    }
    
    @XmlTransient
    public static Map<Integer, Product> getProductList() {
        return productList;
    } 
    
    public static Map<String, Client> getClientList() {
        return clientList;
    }
}
