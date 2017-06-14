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

import com.e_tec.e_tecserverI.model.DistributionCenter;

public class XMLParserDistributionCenter {

	public static List<DistributionCenter> getNodes() {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List<DistributionCenter> distributions = new ArrayList<>();
		DistributionCenter distribution;

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder
					.parse("C:/Users/aguis/Desktop/Programitas Java Web/e_tecserverI/src/main/resources/distributioncenters.xml");
			NodeList nodeList = doc.getElementsByTagName("distribution");

			for (int i = 0; i < nodeList.getLength(); i++) {

				distribution = new DistributionCenter();

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
								distribution.setName(name.getTextContent());
								break;
							case "type":
								distribution.setType(name.getTextContent());
								break;
							case "posX":
								distribution.setPosX(Integer.parseInt(name.getTextContent()));
								break;
							case "posY":
								distribution.setPosY(Integer.parseInt(name.getTextContent()));
								break;
							}
						}
					}

					distributions.add(distribution);
				}
			}

			return distributions;

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
