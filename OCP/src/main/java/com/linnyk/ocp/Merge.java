package com.linnyk.ocp;

import java.util.HashMap;
import java.util.Map;

public class Merge {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		map.put("a", 1);
		map.put("b", 1);

		map.merge("b", 1, (oldValue, newValue) -> {
			System.out.println(oldValue + " " + newValue); //1 1
			return oldValue + newValue;
		});

		map.merge("c", 3, (oldValue, newValue) -> {
			System.out.println(oldValue + " " + newValue);
			return oldValue + newValue;
		});

		System.out.println(map); //{a=1, b=2, c=3}
	}
}
