package com.e_tec.e_tecserverI.xml.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.e_tec.e_tecserverI.model.DistributionCenter;

public class XMLWriterDistributionCenter {
	
	public static void writeXML(List<DistributionCenter> distributionList) {

		try {

			Document document = new Document();

			Element theRoot = new Element("DistributionCenter");
			document.setRootElement(theRoot);
			
			for (DistributionCenter distribution : distributionList) {
				Element node = new Element("distribution");
				
				
				Element name = new Element("name");
				name.addContent(new Text(distribution.getName()));
				Element type = new Element("type");
				type.addContent(new Text(distribution.getType()));
				Element posX = new Element("posX");
				posX.addContent(new Text(distribution.getPosX() + ""));
				Element posY = new Element("posY");
				posY.addContent(new Text(distribution.getPosY() + ""));
				
				node.addContent(name);
				node.addContent(type);
				node.addContent(posX);
				node.addContent(posY);
				
				theRoot.addContent(node);			
				
			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

			outputter.output(document,
					new FileOutputStream(new File("C:/Users/aguis/Desktop/Programitas Java Web/e_tecserverI/src/main/resources/distributioncenters.xml")));
			
			//System.out.println("Wrote to File");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
