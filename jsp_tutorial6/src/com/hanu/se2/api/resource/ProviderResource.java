package com.hanu.se2.api.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hanu.se2.api.model.Provider;
import com.hanu.se2.api.service.ProviderService;
import com.hanu.se2.base.RestResource;

@Path("/providers")
public class ProviderResource extends RestResource<Provider, Integer> {
	
	public ProviderResource() {
		service = new ProviderService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public List<Provider> get() {
		return super.get();
	}
}