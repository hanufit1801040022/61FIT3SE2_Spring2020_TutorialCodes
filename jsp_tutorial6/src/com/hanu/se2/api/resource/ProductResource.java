package com.hanu.se2.api.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hanu.se2.api.model.Product;
import com.hanu.se2.api.service.ProductService;
import com.hanu.se2.base.RestResource;

@Path("/products")
public class ProductResource extends RestResource<Product, Integer> {
	
	public ProductResource() {
		service = new ProductService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public List<Product> get() {
		return super.get();
	}
}
