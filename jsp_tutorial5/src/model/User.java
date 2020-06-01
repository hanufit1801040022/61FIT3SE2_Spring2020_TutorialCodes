package model;

/**
 * This is a model class represents a User entity for the table User in database
 */

public class User {
	protected int id;
	protected String name;
	protected String address;
	protected String mobile;
	
	public User() {
	}
	
	public User(String name, String address, String mobile) {
		super();
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}

	public User(int id, String name, String address, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
