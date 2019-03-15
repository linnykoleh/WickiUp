package com.linnyk.ocp.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListIteratorExample {

	public static void main(String[] args) {
		iteratorExample();
		// 1

		listIteratorExample();
		// 1

		forEachExample();
		// 1
		// ConcurrentModificationException
	}

	private static void iteratorExample() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);

		final Iterator<Integer> iterator = arr.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
	}

	private static void listIteratorExample() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);

		final ListIterator<Integer> iterator = arr.listIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
	}

	private static void forEachExample() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);

		for (Integer o : arr) {
			System.out.println(o);
			arr.remove(o);
		}
	}

}