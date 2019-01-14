package com.unitbv.tema.rest;

import java.sql.SQLException;
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
	//@Path("custmerBilling")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Customer> getcustomers() throws SQLException {
		dalCustomer dalc = new dalCustomer();
		return dalc.getCustomers();

	}
	
	@GET
	@Path("insert")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Customer> Update(@QueryParam("discount") double discount,@QueryParam("billingType") String billingType,@QueryParam("billingAddress") String billingAddress,@QueryParam("creditCards") String creditCards) throws SQLException {
	
		dalCustomer dalc = new dalCustomer();
		dalc.insertCustomer(discount,billingType,billingAddress,creditCards);
		return dalc.getCustomers();
		

	}
	
	@GET
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Customer> Update(@QueryParam("id") long id,@QueryParam("discount") double discount,@QueryParam("billingType") String billingType,@QueryParam("billingAddress") String billingAddress,@QueryParam("creditCards") String creditCards) throws SQLException {
	
		dalCustomer dalc = new dalCustomer();
		dalc.updateCustomer(id, discount,billingType,billingAddress,creditCards);
		return dalc.getCustomers();
		

	}
	
	@GET
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Customer> Delete(@QueryParam("id") int id) throws SQLException {
	
		dalCustomer dalc = new dalCustomer();
		dalc.deleteCustomer(id);
		return dalc.getCustomers();
		

	}

	@GET
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)

	public Customer getcustomer(@QueryParam("id") long id) throws SQLException {

		Customer cust = null;
		List<Customer> customers = new ArrayList<Customer>();
		dalCustomer dalc = new dalCustomer();
		customers = dalc.getCustomers();
		for (Customer c : customers) {

			if (c.getId() == id)
				cust = c;

		}

		return cust;

	}

}