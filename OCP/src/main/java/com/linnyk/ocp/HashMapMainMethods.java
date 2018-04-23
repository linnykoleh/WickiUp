package com.linnyk.ocp;

import java.util.HashMap;

public class HashMapMainMethods {

	public static void main(String[] args) {
		computeIfAbsent();
		System.out.println("---------------");
		computeIfPresent();
		System.out.println("---------------");
		compute();
		System.out.println("---------------");
		merge();
		System.out.println("---------------");
	}

	static void computeIfAbsent(){
		HashMap<Integer, String> map = new HashMap<>();

		map.put(1, "1");
		map.put(2, "2");

		map.computeIfAbsent(1, (key) -> {
			System.out.println(key);
			return "One";
		});

		map.computeIfAbsent(3, (key) -> {
			System.out.println(key); //3
			return "Three";
		});

		System.out.println(map); // {1=1, 2=2, 3=Three}
	}

	static void computeIfPresent(){
		HashMap<Integer, String> map = new HashMap<>();

		map.put(1, "First");
		map.put(2, "Second");

		map.computeIfPresent(1, (key, oldValue) -> {
			System.out.println(key); // 1
			System.out.println(oldValue); // First
			return "One";
		});
		map.computeIfPresent(3, (key, oldValue) -> {
			System.out.println(key);
			System.out.println(oldValue);
			return "Three";
		});

		System.out.println(map); // {1=One, 2=Second}
	}

	static void compute(){
		HashMap<Integer, String> map = new HashMap<>();

		map.put(1, "First");
		map.put(2, "Second");

		map.compute(1, (key, oldValue) -> {
			System.out.println(key); // 1
			System.out.println(oldValue); // First
			return "One";
		});
		map.compute(3, (newKey, oldValue) -> {
			System.out.println(newKey); // 3
			System.out.println(oldValue); // null
			return "Three";
		});

		System.out.println(map); // {1=One, 2=Second, 3=Three}
	}

	static void merge(){
		HashMap<Integer, String> map = new HashMap<>();

		map.put(1, "First");
		map.put(2, "Second");

		map.merge(1, "One", (oldValue, newValue) -> {
			System.out.println(oldValue); // First
			System.out.println(newValue); // One
			return "First+One";
		});
		map.merge(3, "Three", (oldValue, newValue) -> {
			System.out.println(oldValue);
			System.out.println(newValue);
			return "Three+Three";
		});

		System.out.println(map); // {1=First+One, 2=Second, 3=Three}
	}
}
