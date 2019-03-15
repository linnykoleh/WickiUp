package com.linnyk.ocp.iterators;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListIteratorExample {

	public static void main(String[] args) {
		iteratorExample();
		// 1
		// UnsupportedOperationException

		listIteratorExample();
		// 1
		// UnsupportedOperationException

		forEachExample();
		//1
	}

	private static void iteratorExample() {
		CopyOnWriteArrayList<Integer> arr = new CopyOnWriteArrayList<>();
		arr.add(1);

		final Iterator<Integer> iterator = arr.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
	}

	private static void listIteratorExample() {
		CopyOnWriteArrayList<Integer> arr = new CopyOnWriteArrayList<>();
		arr.add(1);

		final ListIterator<Integer> iterator = arr.listIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
	}

	private static void forEachExample() {
		CopyOnWriteArrayList<Integer> arr = new CopyOnWriteArrayList<>();
		arr.add(1);

		for (Integer o : arr) {
			System.out.println(o);
			arr.remove(o);
		}
	}

}
