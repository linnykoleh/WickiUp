package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionBy {

	/**

	 - public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate)

	 - public static <T, D, A> Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate, Collector<? super T, A, D> downstream)

	 */

	private static List<Book> books = Arrays.asList(
			new Book(1, "Name1", 10.0),
			new Book(2, "Name2", 20.0),
			new Book(3, "Name1", 30.0),
			new Book(4, "Name2", 40.0));

	public static void main(String[] args) {
		partitioningByAndPredicate();
		partitioningByAndPredicateAndCollector();
	}

	private static void partitioningByAndPredicate(){
		final Map<Boolean, List<Book>> collect = books.stream().collect(Collectors.partitioningBy(o -> o.getId() <= 2));

		System.out.println(collect);
		// {false=[id=3,name=Name1, id=4,name=Name2], true=[id=1,name=Name1, id=2,name=Name2]}

		final Map<Boolean, List<Book>> collect2 = books.stream().collect(Collectors.partitioningBy(o -> o.getName().endsWith("2")));

		System.out.println(collect2);
		// {false=[id=1,name=Name1, id=3,name=Name1], true=[id=2,name=Name2, id=4,name=Name2]}
	}

	private static void partitioningByAndPredicateAndCollector(){
		final Map<Boolean, Long> collect = books.stream().collect(Collectors.partitioningBy(o -> o.getId() <= 2, Collectors.counting()));

		System.out.println(collect);
		// {false=2, true=2}

		final Map<Boolean, Map<Integer, String>> collect1 =
				books.stream().collect(Collectors.partitioningBy(o -> o.getId() <= 0, Collectors.toMap(Book::getId, Book::getName)));

		System.out.println(collect1);
		// {false={1=Name1, 2=Name2, 3=Name1, 4=Name2}, true={}}

	}

}
