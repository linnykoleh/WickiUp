package com.learning.linnyk.java_brains._1_di;

/**
 * @author LinnykOleh
 */
public class TriangleAutowiringByType {

	private Square square;

	public TriangleAutowiringByType() {

	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public void draw(){
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "TriangleAutowiringByType{" +
				"square=" + square +
				'}';
	}
}
