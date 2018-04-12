package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Averaging {

	/**

	  - public static <T> Collector<T, ?, Double> averagingDouble(ToDoubleFunction<? super T> mapper)

	  - public static <T> Collector<T, ?, Double> averagingInt(ToIntFunction<? super T> mapper)

	  - public static <T> Collector<T, ?, Double> averagingLong(ToLongFunction<? super T> mapper)

	 */

	private static List<Book> books = Arrays.asList(
			new Book(1, "Name1", 10.0),
			new Book(2, "Name2", 20.0),
			new Book(3, "Name1", 30.0),
			new Book(4, "Name2", 40.0));

	public static void main(String[] args) {
		final Double collect = books.stream().collect(Collectors.averagingDouble(Book::getPrice));
		System.out.println(collect); // 25.0

		final Double collect1 = books.stream().collect(Collectors.averagingInt(book -> (int) book.getPrice()));
		System.out.println(collect1); // 25.0

		final Double collect2 = books.stream().collect(Collectors.averagingLong(book -> (long) book.getPrice()));
		System.out.println(collect2); // 25.0
	}
}
