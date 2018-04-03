package com.linnyk.ocp;

public class DefaultMethods2 {

	interface House {

		default String getAddress() {
			return "101 Main Str";
		}
	}

	interface Office {

		static String getAddress(){
			return "101 Smart Str";
		}
	}

	interface WFH extends House, Office{

	}

	static class HomeOffice implements House, Office {

		@Override
		public String getAddress() {
			return "R No 1, Home";
		}
	}

	public static void main(String[] args) {
		Office h = new HomeOffice();
//		System.out.println(h.getAddress()); Static method may be invoked or containing interface class only

		System.out.println(Office.getAddress()); //R No 1, Home
	}
}
