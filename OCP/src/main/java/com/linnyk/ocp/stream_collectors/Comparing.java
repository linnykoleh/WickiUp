package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparing {

	/**
	 	- Optional<T> max(Comparator<? super T> comparator);

	 	- Optional<T> min(Comparator<? super T> comparator);

	 */

	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(10, 47, 33, 23);

		final Integer integer = ls.stream().max(Comparator.comparing(a -> a)).get();
		System.out.println(integer); //47
	}
}
