package com.linnyk.ocp;

class A extends InnerClasses {

}

public class InnerClasses {

	public abstract class A extends com.linnyk.ocp.A{

	}

	public class B extends A {
		final static int number = 1;
//		 static int number1 = 1; Compilation error no static in inner classes
	}

	public static void main(String[] args) {

//		new B(); Compilation error
//		new A(); Compilation error

		new InnerClasses().new A(){

			public void m(){

			}

		};
	}
}
