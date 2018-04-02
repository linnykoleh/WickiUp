package com.linnyk.ocp;

public class OuterClass3 {

	public static void main(String[] args) {
		Outer outer = new Outer();

//		Outer.Inner inner = outer.getInner(); //другой способ инициализции Inner

		System.out.println(outer.getInner().getOi()); //20
	}
}

class Outer{

	private int oi = 20;

	class Inner {

		int getOi(){
			return oi;
		}
	}

	Inner getInner(){
		return new Inner();
	}
}
