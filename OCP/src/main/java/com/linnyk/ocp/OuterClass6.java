package com.linnyk.ocp;

public class OuterClass6 {

	public class A {

	}

	public static class B {

	}

	public void useClass() {
		new A();
		new B();

		new OuterClass6().new A();
//		new OuterClass6().new B(); Compilation Error

		new OuterClass6.B();
		new OuterClass6.A();
	}

	public static void useClass1() {
//		new A(); Compilation Error
		new B();

		new OuterClass6().new A();
//		new OuterClass6().new B(); Compilation Error

		new OuterClass6.B();
//		new OuterClass6.A(); Compilation Error
	}
}
