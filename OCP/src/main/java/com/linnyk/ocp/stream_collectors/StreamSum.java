package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSum {

	public static void main(String[] args) {

		List<Integer> names = Arrays.asList(1, 2, 3);

		System.out.println(names.stream().mapToInt(x -> x).sum()); // 6

		System.out.println(names.stream().reduce(0, (a, b) -> {
			final int i = a + b;
			System.out.println(a + "+" + b + "=" + i); // 0+1=1 -> 1+2=3 -> 3+3=6
			return i;
		})); // 6

		System.out.println(names.stream().collect(Collectors.summarizingInt(value -> value))); // IntSummaryStatistics{count=3, sum=6, min=1, average=2.000000, max=3}
		System.out.println(names.stream().collect(Collectors.summarizingInt(value -> value)).getSum()); // 6

		System.out.println(names.stream().collect(Collectors.mapping(x -> x,  Collectors.summarizingInt(y -> y))).getSum()); // 6
		                                                     // Функция mapping - ничего не делает
	}
}
