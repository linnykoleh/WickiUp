package com.linnik.wickiup.laakmann.data_structures.arrays;

/**
 * @author LinnykOleh
 */
public class OrdArrayMain {

	public static void main(String[] args) {
		final OrdArray ordArray = new OrdArray(new int[20]);

		ordArray.insert(6);
		ordArray.insert(3);
		ordArray.insert(13);
		ordArray.insert(9);
		ordArray.insert(26);
		ordArray.insert(20);
		ordArray.insert(40);
		ordArray.insert(37);
		ordArray.insert(33);

		int i = ordArray.findIndex(37);

		System.out.println("Searching Index is " + i);

		ordArray.print();
	}
}
