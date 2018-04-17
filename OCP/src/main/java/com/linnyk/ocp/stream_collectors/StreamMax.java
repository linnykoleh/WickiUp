package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamMax {

	public static void main(String[] args) {
		final List<Double> list = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0);
		final Double res = list.stream().max(Comparator.comparingDouble(integer -> integer)).get();
		System.out.println(res); // 6.0

		final List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
		final Integer res1 = list1.stream().max(Comparator.comparing(integer -> integer)).get();
		System.out.println(res1); // 6

		final List<Integer> list2 = Arrays.asList(1,2,3,4,5,6);
		final Integer res2 = list2.stream().max(Comparator.comparingInt(integer -> integer)).get();
		System.out.println(res2); // 6

		final List<Integer> list3 = Arrays.asList(1,2,3,4,5,6);
		final Integer res3 = list3.stream().max(Integer::compare).get();
		System.out.println(res3); // 6
	}
}
