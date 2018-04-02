package com.linnyk.ocp;

import java.io.IOException;
import java.sql.SQLException;

interface I1{

	void m1() throws IOException;
}

interface I2{

	void m1() throws SQLException;
}

public class Interfaces implements I1, I2{

	@Override
	public void m1() {
		System.out.println("test");
	}

	public static void main(String[] args) {

		Interfaces interfaces = new Interfaces();

		interfaces.m1(); //test

		try {
			((I1)interfaces).m1(); // I1 method
		}
		catch (IOException e) {	}

		try {
			((I2)interfaces).m1(); // I2 method
		}
		catch (SQLException e) {}

	}
}
