package com.e_tec.e_tecserverI.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.service.ClientService;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterClient;

@Path("cartlist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CartResource {
	
	private ClientService clientService = new ClientService();
	
	@GET
	@Path("{clientName}")
	public ArrayList<Product> getCart(@PathParam("clientName") String clientName) {
		
		Client client = clientService.getClient(clientName);
		
		return client.getCart();
	}
	
	@POST
	@Path("{clientName}")
	public Product addCartClient(@PathParam("clientName") String clientName, Product product) {
		ArrayList<Product> clientCart = clientService.getClient(clientName).getCart();
		clientCart.add(product);		
		XMLWriterClient.writeXML(clientService.getAllClient());
		return product;
	}
	
	@DELETE
	@Path("{clientName}")
	public void deleteCartClient(@PathParam("clientName") String clientName, Product product) {
		ArrayList<Product> clientCart = clientService.getClient(clientName).getCart();
		System.out.println(clientCart.size());
		
		for (Product product1 : clientCart) {
			if (product1.getId() == product.getId()) {
				clientCart.remove(product1);
				break;
			}			
		}
		//clientService.getClient(clientName).setCart(clientCart);		
		XMLWriterClient.writeXML(clientService.getAllClient());
	}
	
	@PUT
	@Path("{clientName}")
	public void clearCart(@PathParam("clientName") String clientName) {
		ArrayList<Product> clientCart = clientService.getClient(clientName).getCart();
		clientCart.clear();		
		XMLWriterClient.writeXML(clientService.getAllClient());
	}
}
