package com.e_tec.e_tecserverI;

import java.util.ArrayList;
import java.util.List;

import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.xml.parser.XMLParserProduct;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterProduct;

public class Main {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product("Dell Inspiron 15", "http://i.dell.com/sites/imagecontent/products/PublishingImages/inspiron-15-5551-5552-5558-laptop/laptop-inspiron-15-5000-polaris-mag-pdp-module-2.jpg", 
						12, 1, "AparatosElectrónicos", "hgogjeg"));
		products.add(new Product("Estufa", "https://s3-us-west-1.amazonaws.com/whirlpool-cdn/wp-content/uploads/2016/06/wf5151d.png",
						53, 1, "Electrodomesticos", "FJDBGB"));
		
		XMLWriterProduct.writeXML(products);
		
		List<Product> products2 = XMLParserProduct.getNodes();
		
		for(Product product : products2) {
			System.out.println(product.getName());
		}
	}

}
