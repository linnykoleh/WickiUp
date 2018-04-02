package com.linnyk.ocp;

public class OuterClass2 {

	int i = 10;

	class InnerClass{

		public void getI(){
			System.out.println(i);
			System.out.println(OuterClass2.this.i);

//			System.out.println(this.i); Compilation error
		}
	}
}
