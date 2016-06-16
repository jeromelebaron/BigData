package com.formation.entity;


public class Product {
	
	private Long id;
	private String name;
	private String manufacturer;
	private String category;
	private double price;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product(Long id, String name, String manufacturer, String category,
			double price) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.category = category;
		this.price = price;
	}
	public Product(String name, String manufacturer, String category,
			double price) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.category = category;
		this.price = price;
	}
	
	public Product() {
		super();
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", manufacturer="
				+ manufacturer + ", category=" + category + ", price=" + price
				+ "]";
	}

}
