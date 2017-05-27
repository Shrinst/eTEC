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

import com.e_tec.e_tecserverI.model.Product;

public class XMLParserProduct {
	
	/**
	 * Read a XML File and save them into new objects
	 * @return the list of read objects
	 */
	public static List<Product> getNodes() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List<Product> products = new ArrayList<>();
		Product product;
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("./src/main/java/org/meditec/meditecserver/xmlFiles/NewFile1.xml");
			NodeList nodeList = doc.getElementsByTagName("Node");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				
				product = new Product();
				
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
								product.setName(name.getTextContent());
								break;
							case "imageURL":
								product.setImageURL(name.getTextContent());
								break;
							case "id":
								product.setId(Integer.parseInt(name.getTextContent()));
								break;
							case "description":
								product.setDescription((name.getTextContent()));
								break;
							}				
						}
					}
					
					products.add(product);
				}
			}
			
			return products;
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return null;
		
	}

}
