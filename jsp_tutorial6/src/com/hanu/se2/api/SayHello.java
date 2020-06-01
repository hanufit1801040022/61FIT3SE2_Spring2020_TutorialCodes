package com.hanu.se2.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sayhello")
public class SayHello {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHello() {
		return "<h2>Hello JAX-WS!</h2>";
	}
}
