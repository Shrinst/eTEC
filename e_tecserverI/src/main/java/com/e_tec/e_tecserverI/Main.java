package com.e_tec.e_tecserverI;

import java.util.ArrayList;
import java.util.List;

import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.xml.parser.XMLParserClient;
import com.e_tec.e_tecserverI.xml.parser.XMLParserProduct;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterClient;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterProduct;

public class Main {

	public static void main(String[] args) {
		List<Client> clients = new ArrayList<Client>();
		Client client = new Client("TOBE", "jfishgos");
		client.getCart().add(new Product("PS4", "JFKDG", 45, 1, 2, "juegos", "GG"));
		client.getCart().add(new Product("PS3", "J", 46, 5, 2, "juegos", "GA"));
		clients.add(client);
		clients.add(new Client("Milton", "NFJBJGG"));
		clients.add(new Client("Noguera", "NFJBJGG"));
		
		XMLWriterClient.writeXML(clients);
		
		List<Client> clients2 = XMLParserClient.getNodes();
		for (int  i = 0; i < clients2.size(); i++) {
			System.out.println("Carta de:" + clients2.get(i).getName());
			ArrayList<Product> products = clients2.get(i).getCart();
			
			for (Product product : products) {
				System.out.print("contiene" + product.getName() + "\n");
			}
		}		
	}
}
