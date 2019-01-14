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

public class ProductRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Product> getProducts() throws SQLException {
		dalProduct dalp = new dalProduct();
		return dalp.getProducts();

	}
	
	@GET
	@Path("insert")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Product> Update(@QueryParam("price") double price,@QueryParam("discount") double discount,@QueryParam("taxes") double taxes) throws SQLException {
	
		dalProduct dalp = new dalProduct();
		dalp.insertProduct(price,discount,taxes);
		return dalp.getProducts();
		

	}
	
	@GET
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Product> Update(@QueryParam("id") long id,@QueryParam("price") double price,@QueryParam("discount") double discount,@QueryParam("taxes") double taxes) throws SQLException {
	
		dalProduct dalp = new dalProduct();
		dalp.updateProduct(id, price,discount,taxes);
		return dalp.getProducts();
		

	}
	
	@GET
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Product> Delete(@QueryParam("id") int id) throws SQLException {
	
		dalProduct dalp = new dalProduct();
		dalp.deleteProduct(id);
		return dalp.getProducts();
		

	}

	@GET
	@Path("product")
	@Produces(MediaType.APPLICATION_JSON)

	public Product getProduct(@QueryParam("id") long id) throws SQLException {

		Product prod = null;
		List<Product> products = new ArrayList<Product>();
		dalProduct dalp = new dalProduct();
		products = dalp.getProducts();
		for (Product p : products) {

			if (p.getId() == id)
				prod = p;

		}

		return prod;

	}

}