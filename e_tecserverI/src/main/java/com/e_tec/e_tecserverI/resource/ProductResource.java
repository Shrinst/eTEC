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

import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.service.ProductService;

@Path("productlist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	ProductService productService = new ProductService();

    @GET
    public List<Product> getProducts(@QueryParam("category") String category) {
        if (category != null) {
            return productService.getAllProductPerCategory(category);
        }

        return productService.getAllProduct();
    }
    
    @POST
	public Product addProduct(Product product) {
		return productService.addProduct(product);
	}
	
	@PUT
	@Path("{productId}")
	public Product updateProduct(@PathParam("productId") int id, Product product) {
		product.setId(id);
		return productService.updateProduct(product);
	}
	
	@DELETE
	@Path("{productId}")
	public void deleteProduct(@PathParam("productId") int id) {
		productService.deleteProduct(id);
	}	
	
	@GET
	@Path("{productId}")
	public Product getProduct(@PathParam("productId") int id) {
		return productService.getProduct(id);
	}
}
