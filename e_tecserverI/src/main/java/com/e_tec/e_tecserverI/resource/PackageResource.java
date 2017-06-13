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

import com.e_tec.e_tecserverI.model.Package;
import com.e_tec.e_tecserverI.service.PackageService;

@Path("package")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PackageResource {
	
	PackageService packageService = new PackageService();

    @GET
    public List<Package> getPackages() {      

        return packageService.getAllPackage();
    }
    
    @POST
	public Package addPackage(Package package1) {
		return packageService.addPackage(package1);
	}
	
	@PUT
	@Path("{package}")
	public Package updatePackage(@PathParam("package") int code, Package package1) {
		package1.setCode(code);
		return packageService.updatePackage(package1);
	}
	
	@DELETE
	@Path("{center}")
	public void deletePackage(@PathParam("center") int code) {
		packageService.deletePackage(code);
	}	
	
	@GET
	@Path("{center}")
	public Package getPackage(@PathParam("center") int code) {
		return packageService.getPackage(code);
	}	
}
