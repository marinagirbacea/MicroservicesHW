package com.unitbv.tema.rest;

public class Customer {

	private long id;

	private double discount ;

	private String billingType;
	
	private String billingAddress;
	
	private String creditCards;

	public Customer(double discount, String billingType, String billingAddress, String creditCards) {
		super();
		this.setDiscount(discount);
		this.setBillingType(billingType);
		this.setBillingAddress(billingAddress);
		this.setCreditCards(creditCards);
	}

	public Customer(long id,double discount, String billingType, String billingAddress, String creditCards) {
		super();
		this.id = id;
		this.setDiscount(discount);
		this.setBillingType(billingType);
		this.setBillingAddress(billingAddress);
		this.setCreditCards(creditCards);
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {

		return id;

	}

	public void setId(long id) {

		this.id = id;

	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(String creditCards) {
		this.creditCards = creditCards;
	}

	

}
