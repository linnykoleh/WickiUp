package com.linnyk.ocp;

public class OuterClass5 {

	public static class Inner{

	}

	public static void main(String[] args) {
		Inner inner = new Inner();

		OuterClass5.Inner inner1 = new OuterClass5.Inner();

		Inner inner2 = new OuterClass5.Inner();
	}
}
