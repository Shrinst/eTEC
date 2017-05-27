package com.e_tec.e_tecserverI.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.service.ClientService;

@Path("cartlist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CartResource {
	
	private ClientService clientService = new ClientService();
	
	@GET
	@Path("{clientName}")
	public ArrayList<Product> getCart(@PathParam("clientName") String clientName) {
		
		for (Client client : clientService.getClientList().values()) {
			if (client.getName().equals(clientName)) {
				return client.getCart();
			}
		}
		
		return null;
	}
	
	@POST
	@Path("{clientName}")
	public Product addCartClient(@PathParam("clientName") String clientName, Product product) {
		ArrayList<Product> clientCart = clientService.getClient(clientName).getCart();
		clientCart.add(product);		
		return product;
	}
	
	@DELETE
	@Path("{clientName}")
	public void deleteCartClient(@PathParam("clientName") String clientName, Product product) {
		ArrayList<Product> clientCart = clientService.getClient(clientName).getCart();
		
		for (Product product1 : clientCart) {
			if (product1.getName().equals(product.getName())) {
				clientCart.remove(product1);
				break;
			}			
		}
		System.out.println(clientCart.size());
		clientService.getClient(clientName).setCart(clientCart);		
	}
}
