package com.unitbv.tema.rest;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")

public class CustomerRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Customer> getProducts() {
		dal dal = new dal();
		return dal.getCustomers();

	}
	
	@GET
	@Path("insert")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Customer> Update(@QueryParam("name") String name,@QueryParam("email") String email,@QueryParam("address") String address,@QueryParam("password") String password) {
	
		dal dal = new dal();
		dal.insertCustomer(name, email,address,password);
		return dal.getCustomers();
		

	}
	
	@GET
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Customer> Update(@QueryParam("id") long id,@QueryParam("name") String name,
			@QueryParam("email") String email,@QueryParam("address") String address,@QueryParam("password") String password) {
	
		dal dal = new dal();
		dal.updateCustomer(id, name, email, address, password);
		return dal.getCustomers();
		

	}
	
	@GET
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Customer> Delete(@QueryParam("id") int id) {
	
		dal dal = new dal();
		dal.deleteCustomer(id);
		return dal.getCustomers();
		

	}

	@GET
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)

	public Customer getProduct(@QueryParam("id") long id) {

		Customer prod = null;
		List<Customer> products = new ArrayList<Customer>();
		dal dal = new dal();
		products = dal.getCustomers();
		for (Customer p : products) {

			if (p.getId() == id)
				prod = p;

		}

		return prod;

	}

}