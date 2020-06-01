package com.hanu.model;

public class Provider {
	private int id;
	private String name;
	
	public Provider(String name) {
		super();
		this.name = name;
	}

	public Provider(int id, String name) {
		this.id = id;
		this.name = name;
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
