package com.e_tec.e_tecserverI.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.service.ClientService;

@Path("clientlist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
	
	ClientService clientService = new ClientService();

    @GET
    public List<Client> getClient(@QueryParam("year") int filterBean) {
        /*if (filterBean > 0) {
            return productService.getAllMessageForYear(filterBean);
        }*/

        return clientService.getAllClient();
    }
    
    @POST
	public Client addClient(Client client) {
    	Client client1 = new Client(client.getName(), client.getPhoto());
		return clientService.addClient(client1);
	}
	
	@PUT
	@Path("{clientName}")
	public Client updateClient(@PathParam("clientName") String clientName, Client client) {
		client.setName(clientName);
		return clientService.updateClient(client);
	}
	
	@DELETE
	@Path("{clientName}")
	public void deleteClient(@PathParam("clientName") String name) {
		clientService.deleteClient(name);
	}	
	
	@GET
	@Path("{clientName}")
	public Client getClient(@PathParam("clientName") String name) {
		return clientService.getClient(name);
	}	
}
