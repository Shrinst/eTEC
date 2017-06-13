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
import javax.ws.rs.core.MediaType;

import com.e_tec.e_tecserverI.model.DistributionCenter;
import com.e_tec.e_tecserverI.service.DistributionCenterService;

@Path("distributioncenter")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DistributionCenterResource {
	
	DistributionCenterService distributionService = new DistributionCenterService();

    @GET
    public List<DistributionCenter> getDistributionCenters() {      

        return distributionService.getAllDistributionCenter();
    }
    
    @POST
	public DistributionCenter addDistributionCenter(DistributionCenter distribution) {
		return distributionService.addClient(distribution);
	}
	
	@PUT
	@Path("{center}")
	public DistributionCenter updateDistributionCenter(@PathParam("center") String name, DistributionCenter distribution) {
		distribution.setName(name);
		return distributionService.updateClient(distribution);
	}
	
	@DELETE
	@Path("{center}")
	public void deleteDistributionCenter(@PathParam("center") String name) {
		distributionService.deleteDistributionCenter(name);
	}	
	
	@GET
	@Path("{center}")
	public DistributionCenter getDistributionCenter(@PathParam("center") String name) {
		return distributionService.getDistributionCenter(name);
	}	
}
