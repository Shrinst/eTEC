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

			Element theRoot = new Element("Products");
			document.setRootElement(theRoot);
			
			for (Product product : productList) {
				Element node = new Element("product");
				
				
				Element name = new Element("name");
				name.addContent(new Text(product.getName()));
				Element imageURL = new Element("imageURL");
				imageURL.addContent(new Text(product.getImageURL()));
				Element id = new Element("id");
				id.addContent(new Text(product.getId() + ""));
				Element description = new Element("description");
				description.addContent(new Text(product.getDescription()));
				Element category = new Element("category");
				category.addContent(new Text(product.getCategory()));
				Element amount = new Element("amount");
				amount.addContent(new Text(String.valueOf(product.getAmount())));
				Element price = new Element("price");
				price.addContent(new Text(String.valueOf(product.getPrice())));
				
				node.addContent(name);
				node.addContent(imageURL);
				node.addContent(id);
				node.addContent(description);
				node.addContent(category);
				node.addContent(amount);
				node.addContent(price);
				
				theRoot.addContent(node);			
				
			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

			outputter.output(document,
					new FileOutputStream(new File("C:/Users/aguis/Desktop/Programitas Java Web/e_tecserverI/src/main/resources/products.xml")));
			
			//System.out.println("Wrote to File");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
