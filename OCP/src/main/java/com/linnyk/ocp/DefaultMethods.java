package com.linnyk.ocp;

public class DefaultMethods {

	interface House {

		default String getAddress() {
			return "101 Main Str";
		}
	}

	interface Office {

		default String getAddress(){
			return "101 Smart Str";
		}
	}

	static class HomeOffice implements House, Office {

		/*
		 Мы должный переопределить этот метод,
		 иначе будет ошибка компиляции

		 HomeOffice inherits unrelated default for getAddress() from House and Office
		  */
		@Override
		public String getAddress() {
			return "R No 1, Home";
		}
	}

	public static void main(String[] args) {
		House h = new HomeOffice();
		System.out.println(h.getAddress()); //R No 1, Home
	}
}
