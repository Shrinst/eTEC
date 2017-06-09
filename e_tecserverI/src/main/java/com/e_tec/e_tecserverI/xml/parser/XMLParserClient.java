package com.e_tec.e_tecserverI.xml.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.model.Product;

public class XMLParserClient {
	
public static List<Client> getNodes() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List<Client> clients = new ArrayList<>();
		Client client;
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:/Users/aguis/Desktop/Programitas Java Web/e_tecserverI/src/main/resources/clients.xml");
			NodeList nodeList = doc.getElementsByTagName("client");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				
				client = new Client();
				
				Node node = nodeList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					NodeList children = element.getChildNodes();
					
					for (int j = 0; j < children.getLength(); j++) {
						Node n = children.item(j);
						
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element name = (Element) n;
							
							switch (name.getTagName()) {
							case "name":
								client.setName(name.getTextContent());
								break;
							case "photo":
								client.setPhoto(name.getTextContent());
								break;	
							case "cart":
								client.setCart(getCart(name));
								break;
							}				
						}
					}
					clients.add(client);
				}
			}
			
			return clients;
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return null;		
	}

	private static ArrayList<Product> getCart(Element cart) {
		NodeList nodeList = cart.getChildNodes();	
		ArrayList<Product> products = new ArrayList<>();
		Product product;
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			product = new Product();
			Node n = nodeList.item(i);			
			
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) n;	
				
				NodeList children = element.getChildNodes();
				
				for (int j = 0; j < children.getLength(); j++) {
					Node child = children.item(j);
					
					if (child.getNodeType() == Node.ELEMENT_NODE) {
						Element name1 = (Element) child;
						switch (name1.getTagName()) {
						case "name":
							product.setName(name1.getTextContent());
							break;
						case "imageURL":
							product.setImageURL(name1.getTextContent());
							break;
						case "id":
							product.setId(Integer.parseInt(name1.getTextContent()));
							break;
						case "description":
							product.setDescription((name1.getTextContent()));
							break;
						case "category":
							product.setCategory(name1.getTextContent());
							break;
						case "amount":
							product.setAmount(Integer.parseInt(name1.getTextContent()));
							break;
						case "price":
							product.setPrice(Integer.parseInt(name1.getTextContent()));
						}								
					}
				}	
				products.add(product);
			}	
		}
		
		return products;
	}
}
