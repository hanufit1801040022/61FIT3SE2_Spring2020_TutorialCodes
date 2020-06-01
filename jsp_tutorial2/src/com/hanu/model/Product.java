package com.hanu.model;

public class Product {
	private int id;
	private String name;
	private long listPrice;
	
	public Product(String name, long listPrice) {
		super();
		this.name = name;
		this.listPrice = listPrice;
	}

	public Product(int id, String name, long listPrice) {
		this.id = id;
		this.name = name;
		this.listPrice = listPrice;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the listPrice
	 */
	public long getListPrice() {
		return listPrice;
	}
	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(long listPrice) {
		this.listPrice = listPrice;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
