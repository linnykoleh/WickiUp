package com.linnyk.ocp.stream_collectors;

import java.util.stream.IntStream;

public class StreamLimitSkip {

	public static void main(String[] args) {
		_5();
	}

	private static void _1(){
		final IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

		intStream.skip(2).limit(3).forEach(System.out::print); // 3 4 5
	}

	private static void _2(){
		final IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		intStream.limit(3).skip(2).forEach(System.out::print); // 3

		final IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		intStream1.limit(2).skip(3).forEach(System.out::print); // Empty
	}

	private static void _3(){
		IntStream.iterate(0, i -> i + 1)
				.limit(10)
				.forEach((x) -> System.out.print(x + " ")); // 0 1 2 3 4 5 6 7 8 9
	}

	private static void _4(){
		IntStream.iterate(0, i -> i + 1)
				.limit(10)
				.skip(5)
				.forEach((x) -> System.out.print(x + " ")); // 5 6 7 8 9
	}

	private static void _5(){
		IntStream.iterate(0, i -> i + 1)
				.skip(5)
				.limit(10)
				.forEach((x) -> System.out.print(x + " ")); // 5 6 7 8 9 10 11 12 13 14
	}

}
