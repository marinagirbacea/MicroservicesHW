package com.unitbv.tema.rest;

public class Product {

	private long id;

	private double price;

	private double discount;
	
	private double taxes;

	public Product(double price,double discount,double taxes) {
		super();
		this.setPrice(price);
		this.setDiscount(discount);
		this.setTaxes(taxes);
	}

	public Product(long id,double price,double discount,double taxes) {
		super();
		this.id = id;
		this.setPrice(price);
		this.setDiscount(discount);
		this.setTaxes(taxes);
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {

		return id;

	}

	public void setId(long id) {

		this.id = id;

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	

}
