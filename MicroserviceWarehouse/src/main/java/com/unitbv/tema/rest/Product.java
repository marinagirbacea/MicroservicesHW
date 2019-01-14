package com.unitbv.tema.rest;

public class Product {

	public int id;
	public double stock;
	public String location;
	public boolean availability;
	public double volume;
	public String storageCondition;

	public Product() {

	}

	public Product(int id, double stock, String location, boolean availability, double volume,
			String storageCondition) {
		super();
		this.id = id;
		this.stock = stock;
		this.location = location;
		this.availability = availability;
		this.volume = volume;
		this.storageCondition = storageCondition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getStorageCondition() {
		return storageCondition;
	}

	public void setStorageCondition(String storageCondition) {
		this.storageCondition = storageCondition;
	}

}
