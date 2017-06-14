package com.e_tec.e_tecserverI.xml.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.e_tec.e_tecserverI.model.Package;

public class XMLWriterPackage {
	
	/**
	 * Get a list of objects and write them into the XML File
	 * @param packageList list of objects 
	 */
	
	public static void writeXML(List<Package> packageList) {

		try {

			Document document = new Document();

			Element theRoot = new Element("Packages");
			document.setRootElement(theRoot);
			
			for (Package package1 : packageList) {
				Element node = new Element("package");
				
				
				Element code = new Element("code");
				code.addContent(new Text(package1.getCode() + ""));
				Element status = new Element("status");
				status.addContent(new Text(package1.getStatus() + ""));
				Element initPosX = new Element("initPosX");
				initPosX.addContent(new Text(package1.getInitPosX() + ""));
				Element initPosY = new Element("initPosY");
				initPosY.addContent(new Text(package1.getInitPosY() + ""));
				Element finPosX = new Element("finPosX");
				finPosX.addContent(new Text(package1.getFinPosX() + ""));
				Element finPosY = new Element("finPosY");
				finPosY.addContent(new Text(package1.getFinPosY() + ""));
				
				node.addContent(code);
				node.addContent(status);
				node.addContent(initPosX);
				node.addContent(initPosY);
				node.addContent(finPosX);
				node.addContent(finPosY);
				
				theRoot.addContent(node);			
				
			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

			outputter.output(document,
					new FileOutputStream(new File("C:/Users/aguis/Desktop/Programitas Java Web/e_tecserverI/src/main/resources/packages.xml")));
			
			//System.out.println("Wrote to File");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
