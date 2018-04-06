package com.linnyk.ocp;

class A{

}

public class InnerClasses {

	public class A{

	}

	public class B extends A {

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
