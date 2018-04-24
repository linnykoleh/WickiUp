package com.linnyk.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reduce {

	public static void main(String[] args) {
		List<String> letters = Arrays.asList("j", "a", "v", "a");

		String word = letters.stream().reduce("", (a, b) -> a.concat(b));
		System.out.println(word); //java

		String word1 = letters.stream().collect(Collectors.joining());
		System.out.println(word1); //java

		System.out.println("-----------------------");

		final String s = letters.stream().reduce((l1, l2) -> l1 + l2).orElse("");
		System.out.println(s);

		System.out.println("-----------------------");

		Integer arrSum = Stream.of(1, 2, 3, 4, 5).parallel().reduce(10, (x,y) -> {
			final int i = x + y;
			System.out.println("accumulator called " + i);
			return i;
			/**/
		}, (p, q) -> {
			final int i = p + q;
			System.out.println("combiner called " + i);
			return i;
		});
		System.out.println(arrSum);

		// accumulator called 13
		// accumulator called 14
		// accumulator called 15
		// accumulator called 12
		// accumulator called 11
		// combiner called 23
		// combiner called 29
		// combiner called 42
		// combiner called 65
		// 65
		//
		//combiner вызвался только на parallel стриме, если sequential то не вызывается
		//Combiner is called only in a parallel mode to reduce results of accumulators from different threads
	}


}
