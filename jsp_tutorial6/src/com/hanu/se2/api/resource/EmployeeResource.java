package com.hanu.se2.api.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hanu.se2.api.model.Employee;
import com.hanu.se2.api.service.EmployeeService;
import com.hanu.se2.base.RestResource;

@Path("/employees")
public class EmployeeResource extends RestResource<Employee, Integer> {
	
	public EmployeeResource() {
		service = new EmployeeService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public List<Employee> get() {
		return super.get();
	}
}
