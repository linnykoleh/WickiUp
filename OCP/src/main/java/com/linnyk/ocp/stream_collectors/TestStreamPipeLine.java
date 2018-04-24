package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamPipeLine {

	public static void main(String[] args) {

		IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
				.filter(i -> {
					System.out.println("filter " + i + " ");
					return i > 3;
				})
				.filter(i -> {
					System.out.println("filter1 " + i + " ");
					return i > 6;
				})
				.forEach(i -> System.out.println("forEach " + i));

		// filter 1
		// filter 2
		// filter 3
		// filter 4
		// filter1 4
		// filter 5
		// filter1 5
		// filter 6
		// filter1 6
		// filter 7
		// filter1 7
		// forEach 7
		// filter 8
		// filter1 8
		// forEach 8
		// filter 9
		// filter1 9
		// forEach 9
		// filter 0

		Stream<Integer> values = IntStream.rangeClosed(0, 10).boxed();
		final boolean b = values.peek(System.out::println).anyMatch(x -> x == 5);

		// 0
		// 1
		// 2
		// 3
		// 4
		// 5

		IntStream.range(0, 9).parallel().forEach(System.out::print); // 510462378
		System.out.println();
		IntStream.range(0, 9).parallel().forEachOrdered(System.out::print); // 012345678
		System.out.println();

		List<StringBuilder> list = Arrays.asList(new StringBuilder("Java"), new StringBuilder("Hello"));
		list.stream().map((x) -> x.append(" World")); //Не выполниться даже
		list.forEach(System.out::println);
		// Java
		// Hello

	}
}
