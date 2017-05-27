package com.e_tec.e_tecserverI.xml.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.e_tec.e_tecserverI.model.Product;

public class XMLWriterProduct {
	
	/**
	 * Get a list of objects and write them into the XML File
	 * @param productList list of objects 
	 */
	
	public static void writeXML(List<Product> productList) {

		try {

			Document document = new Document();

			Element theRoot = new Element("BinaryTree");
			document.setRootElement(theRoot);
			
			for (Product product : productList) {
				Element node = new Element("Node");
				
				
				Element name = new Element("name");
				name.addContent(new Text(product.getName()));
				Element imageURL = new Element("imageURL");
				imageURL.addContent(new Text(product.getImageURL()));
				Element id = new Element("id");
				id.addContent(new Text(product.getId() + ""));
				Element description = new Element("description");
				description.addContent(new Text(product.getDescription()));
				
				node.addContent(name);
				node.addContent(imageURL);
				node.addContent(id);
				node.addContent(description);
				
				theRoot.addContent(node);			
				
			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

			outputter.output(document,
					new FileOutputStream(new File("./src/main/java/org/meditec/meditecserver/xmlFiles/NewFile1.xml")));
			
			System.out.println("Wrote to File");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
