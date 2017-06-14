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

import com.e_tec.e_tecserverI.model.Package;

public class XMLParserPackage {
	
public static List<Package> getNodes() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List<Package> packages = new ArrayList<>();
		Package package1;
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("C:/Users/aguis/Desktop/Programitas Java Web/e_tecserverI/src/main/resources/packages.xml");
			NodeList nodeList = doc.getElementsByTagName("package");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				
				package1 = new Package();
				
				Node node = nodeList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					NodeList children = element.getChildNodes();
					
					for (int j = 0; j < children.getLength(); j++) {
						Node n = children.item(j);
						
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element name = (Element) n;
							
							switch (name.getTagName()) {
							case "code":
								package1.setCode(Integer.parseInt(name.getTextContent()));
								break;
							case "status":
								package1.setStatus(Integer.parseInt(name.getTextContent()));
								break;
							case "initPosX":
								package1.setInitPosX(Integer.parseInt(name.getTextContent()));
								break;
							case "initPosY":
								package1.setInitPosY(Integer.parseInt(name.getTextContent()));
								break;
							case "finPosX":
								package1.setFinPosX(Integer.parseInt(name.getTextContent()));
								break;
							case "finPosY":
								package1.setFinPosY(Integer.parseInt(name.getTextContent()));
								break;
							}				
						}
					}
					
					packages.add(package1);
				}
			}
			
			return packages;
			
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
