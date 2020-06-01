package com.hanu.se2.api.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Provider {
	private int id;
	private String name;
	
	public Provider() {
		// TODO Auto-generated constructor stub
	}
	
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
