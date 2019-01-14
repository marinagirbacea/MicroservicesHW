package com.unitbv.tema.rest;

public class Customer {

	private long id;

	private String name;

	private String email;
	
	private String address;
	
	private String password;


	public Customer(String name, String email,String address,String password) {
		super();
		this.name = name;
		this.email = email;
		this.address=address;
		this.password=password;
	}

	public Customer(long id, String name, String email,String address,String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address=address;
		this.password=password;
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

	public String getName() {

		return name;

	}

	public void setNome(String name) {

		this.name = name;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
