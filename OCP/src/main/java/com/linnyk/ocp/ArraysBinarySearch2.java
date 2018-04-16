package com.linnyk.ocp;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysBinarySearch2 {

	static class StringComparator implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			final int i1 = ((String) o1).length();
			final int i2 = ((String) o2).length();
			System.out.println(o1);
			System.out.println(o2);
			return i1 - i2;
		}
	}
	public static void main(String[] args) {
		String[] sa = {"d", "bbb", "aaaa"};

		System.out.println(Arrays.binarySearch(sa, "cc", new StringComparator())); // -2
		System.out.println(Arrays.binarySearch(sa, "c", new StringComparator())); // 0
	}
}
