package com.hanu.se2.api.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hanu.se2.api.model.Student;
import com.hanu.se2.api.service.StudentService;

@Path("/student")
public class StudentResource {
	
	StudentService service = new StudentService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getStudents() {
		return service.getAll();
	}
}
