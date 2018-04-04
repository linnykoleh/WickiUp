package com.linnyk.ocp;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysBinarySearch {

	static String[] sa = {"a", "aa", "aaa", "aaaa"};

	static {
		Arrays.sort(sa);
	}

	public static void main(String[] args) {
		Stream.of(sa).forEach(System.out::println); //a aa aaa aaaa

		String search = "";
		if(args.length != 0) search = args[0];

//		Этот метод возвращает индекс ключа поиска, если он содержится в массиве, иначе он возвращает (- (точка ввода) - 1)
		System.out.println(Arrays.binarySearch(sa, "b"));       // -5 -> 4 -> -4 -> -4 -1 = -5
		System.out.println(Arrays.binarySearch(sa, "a"));       // 0
		System.out.println(Arrays.binarySearch(sa, "aaaaa"));   // -5 -> 4 -> -4 -> -4 -1 = -5

		System.out.println(Arrays.binarySearch(sa, search));         // -1 -> 0 - 1 = -1
	}
}
