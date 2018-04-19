package com.linnyk.ocp.inner;

public class OuterClass {

	public void outerMethod(){
		InnerClass innerClass1 = new InnerClass();
	}

	public class InnerClass {

	}

	public static void main(String[] args) {

		OuterClass outerClass = new OuterClass();

		InnerClass innerClass1 = outerClass.new InnerClass();
		InnerClass innerClass2 = new OuterClass().new InnerClass();

	}
}
