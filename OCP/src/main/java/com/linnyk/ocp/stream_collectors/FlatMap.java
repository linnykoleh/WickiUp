package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.List;

public class FlatMap {

	private static List<List<Book>> books = Arrays.asList(
				Arrays.asList(
					new Book(1, "Name1", 7.0),
					new Book(2, "Name2", 9.0)),
				Arrays.asList(
					new Book(3, "Name1", 5.0),
					new Book(4, "Name2", 5.0)));

	public static void main(String[] args) {
		final double sum = books.stream()
				.flatMap(bs -> bs.stream())
				.mapToDouble(book -> book.getPrice()).sum();
		System.out.println(sum); // 26.0
	}
}
