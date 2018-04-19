package com.linnyk.ocp;

public class NPE {

	Integer i;

	public static void main(String[] args) {
		String s;
		try{
			s = new NPE().i.toString();
		}finally {
			try{
				int i = Integer.parseInt("ee");
			}catch (NumberFormatException e){
				System.out.println("NumberFormat");
			}finally {
				System.out.println("Fin2 ");
			}
			System.out.println("Fin1 ");
		}

		/*
		NumberFormat
		Fin2
		Fin1
		Exception in thread "main" java.lang.NullPointerException
			at com.linnyk.ocp.NPE.main(NPE.java:10)

		*/
	}
}
