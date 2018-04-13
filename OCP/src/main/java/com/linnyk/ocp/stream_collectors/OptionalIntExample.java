package com.linnyk.ocp.stream_collectors;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OptionalIntExample {

	public static void main(String[] args) {
		final IntStream is = IntStream.range(1, 5);
		final OptionalInt reduce = is.reduce((a, b) -> a + b);

		System.out.println(reduce.orElse(0));
	}
}
