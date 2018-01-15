package com.enterprise.test.api;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.enterprise.test.api.exceptions.DuplicateEmployeeIDException;
import com.enterprise.test.api.exceptions.EmployeeNotFoundException;
import com.enterprise.test.api.model.Employee;


@Component
@Path("/v1")
public class EmployeeAPI {
	
	private static final Map<Integer, Employee> map = new LinkedHashMap<>();
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeAPI.class);
	
	@GET
	@Path("/employee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEmployees(){
		
		LOGGER.info("fetching employees...");
		List<Employee> employees = new LinkedList<Employee>();
		
		for(int key : map.keySet()) {
			employees.add(map.get(key));
		}		
		return Response.status(Response.Status.OK).entity(employees).build();
	}

	@GET
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEmployee(@PathParam("id") int id) throws Exception{

		if(!map.containsKey(id)) {
			throw new EmployeeNotFoundException("Employee with id="+id+" is not found in the system",
					Response.status(Response.Status.BAD_REQUEST).build());
		}
		
		LOGGER.info("fetching employee details...");
		return Response.status(Response.Status.OK).entity(map.get(id)).build();
	}
	
	@POST
	@Path("/employee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEmployee(Employee employee) throws Exception{
		
		if(map.containsKey(employee.getId())) {
			throw new DuplicateEmployeeIDException("Employee ID Already exists in the System. Kindly input New Employee ID",Response.status(Response.Status.BAD_REQUEST).build());					
		}

		LOGGER.info("creating employee...");
		
		map.put(employee.getId(), employee);
		return Response.status(Response.Status.CREATED).build();
	}
	
	@DELETE
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") int id){
		
		LOGGER.info("deleting employee...");
		map.remove(id);
		return Response.status(Response.Status.ACCEPTED).build();
	}
	
	@PUT
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("id") int id, Employee employee) throws Exception{
		
		if(!map.containsKey(id)) {
			throw new EmployeeNotFoundException("Employee with id="+id+" is not found in the system hence update cannot be done",
					Response.status(Response.Status.BAD_REQUEST).build());
		}

		if(employee.getId()!=0) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else {
			LOGGER.info("updating employee...");
			employee.setId(id);
			map.put(id, employee);
			return Response.status(Response.Status.ACCEPTED).build();
		}
	}
}
