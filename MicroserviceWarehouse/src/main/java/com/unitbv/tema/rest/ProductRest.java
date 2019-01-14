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

public class ProductRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Product> getProducts() {
		dal dal = new dal();
		return dal.getProducts();

	}

	@GET
	@Path("insert")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Product> Insert(@QueryParam("stock") Double stock, @QueryParam("location") String location,
			@QueryParam("availability") Boolean availability, @QueryParam("volume") Double volume,
			@QueryParam("storageCondition") String storageCondition) {

		dal dal = new dal();
		dal.insertProduct(stock, location, availability, volume, storageCondition);
		return dal.getProducts();

	}

	@GET
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Product> Update(@QueryParam("id") int id, @QueryParam("stock") Double stock,
			@QueryParam("location") String location, @QueryParam("availability") Boolean availability,
			@QueryParam("volume") Double volume, @QueryParam("storageCondition") String storageCondition) {

		dal dal = new dal();
		dal.updateProduct(id, stock, location, availability, volume, storageCondition);
		return dal.getProducts();

	}

	@GET
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Product> Delete(@QueryParam("id") int id) {

		dal dal = new dal();
		dal.deleteProduct(id);
		return dal.getProducts();

	}

	@GET
	@Path("Product")
	@Produces(MediaType.APPLICATION_JSON)

	public Product getProduct(@QueryParam("id") long id) {

		Product prod = null;
		List<Product> Products = new ArrayList<Product>();
		dal dal = new dal();
		Products = dal.getProducts();
		for (Product p : Products) {

			if (p.getId() == id)
				prod = p;

		}

		return prod;

	}

}
