package com.linnyk.ocp;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapReplace {

	public static void main(String[] args) {
		final Map<Integer, String> map = new TreeMap<>();

		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");

		map.replace(1, "1", null);
		map.replace(3, null);

		System.out.println(map); // {1=One, 2=Two, 3=null}

		map.replace(1, "One", null);

		System.out.println(map); // {1=null, 2=Two, 3=null}
	}
}
