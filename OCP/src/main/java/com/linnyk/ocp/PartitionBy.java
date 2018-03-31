package com.linnyk.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitionBy {

	public static void main(String[] args) {
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
		Stream<Integer> primesStream = primes.stream();

		Predicate<Integer> test1 = k -> k > 10;

		final Map<Boolean, List<Integer>> collect = primesStream.collect(Collectors.partitioningBy(test1));
		System.out.println(collect); //{false=[2, 3, 5, 7], true=[11, 13, 17]}

		collect.values().forEach(System.out::println);
		/*
		 [2, 3, 5, 7]
		 [11, 13, 17]
		*/
	}
}
