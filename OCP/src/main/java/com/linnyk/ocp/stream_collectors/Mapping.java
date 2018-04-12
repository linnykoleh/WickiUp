package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapping {

	/**

	  -  public static <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream) {

	 */

	private static List<Book> books = Arrays.asList(
			new Book(1, "Name1", 10.0),
			new Book(2, "Name2", 20.0),
			new Book(3, "Name1", 30.0),
			new Book(4, "Name2", 40.0));

	public static void main(String[] args) {
		final List<Integer> collect = books.stream().collect(Collectors.mapping(Book::getId, Collectors.toList()));
		System.out.println(collect);
		// [1, 2, 3, 4]

		final List<String> collect1 = books.stream().collect(Collectors.mapping(Book::getName, Collectors.toList()));
		System.out.println(collect1);
		// [Name1, Name2, Name1, Name2]

		final Long collect2 = books.stream().collect(Collectors.mapping(Book::getName, Collectors.counting()));
		System.out.println(collect2);
		// 4

		final Map<String, List<String>> collect3 = books.stream().collect(Collectors.mapping(Book::getName, Collectors.groupingBy(o -> o.toUpperCase())));
		System.out.println(collect3);
		// {NAME2=[Name2, Name2], NAME1=[Name1, Name1]}

		final Set<String> collect4 = books.stream().collect(Collectors.mapping(Book::getName, Collectors.toSet()));
		System.out.println(collect4);
		// [Name1, Name2]

		final String collect5 = books.stream().collect(Collectors.mapping(Book::getName, Collectors.joining()));
		System.out.println(collect5);
		// Name1Name2Name1Name2
	}
}
