package com.learning.linnyk.java_brains._2_scope_lifecycle;

/**
 * @author LinnykOleh
 */
public class Triangle {

	private String type;
	private String color;

	public Triangle(String type, String color) {
		this.type = type;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Triangle{" +
				"type='" + type + '\'' +
				", color='" + color + '\'' +
				'}';
	}
}
