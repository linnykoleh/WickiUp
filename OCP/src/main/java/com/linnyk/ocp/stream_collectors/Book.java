package com.linnyk.ocp.stream_collectors;

public class Book {

	private int id;
	private String name;
	private double price;

	public Book(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "id=" + id + ",name=" + name;
	}
}