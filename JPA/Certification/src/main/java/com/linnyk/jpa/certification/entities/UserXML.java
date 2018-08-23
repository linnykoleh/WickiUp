package com.linnyk.jpa.certification.entities;

public class UserXML {

	private int id;
	private String name;

	public UserXML(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public UserXML() {
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
}
