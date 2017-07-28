package com.learning.linnyk.di;

/**
 * @author LinnykOleh
 */
public class TriangleAutowiringByConstructor {

	private Square square;

	public TriangleAutowiringByConstructor(Square square) {
		this.square = square;
	}

	public void draw(){
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "TriangleAutowiringByConstructor{" +
				"square=" + square +
				'}';
	}
}
