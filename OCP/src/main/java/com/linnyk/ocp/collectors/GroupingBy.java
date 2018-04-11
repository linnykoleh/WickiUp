package com.linnyk.ocp.collectors;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupingBy {

	/**

	  - public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier)

	  - public static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
	 																     Collector<? super T, A, D> downstream)

	  - public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
	 																				  Supplier<M> mapFactory,
	  																		          Collector<? super T, A, D> downstream)

	 */

	private static List<Book> books = Arrays.asList(
			new Book(1, "Name1"),
			new Book(2, "Name2"),
			new Book(3, "Name1"),
			new Book(4, "Name2"));

	public static void main(String[] args) {
		groupingByFunction();
		groupingByFunctionAndCollector();
		groupingByFunctionSupplierCollector();
	}

	private static void groupingByFunction(){
		final Map<Integer, List<Book>> collect = books.stream().collect(Collectors.groupingBy(Book::getId));

		System.out.println(collect);
		// {1=[id=1,name=Name1], 2=[id=2,name=Name2], 3=[id=3,name=Name1], 4=[id=4,name=Name2]}
	}

	private static void groupingByFunctionAndCollector(){
		final Map<Integer, Map<Integer, String>> collect =
				books.stream().collect(Collectors.groupingBy(Book::getId, Collectors.toMap(Book::getId, Book::getName)));

		System.out.println(collect);
		// {1={1=Name1}, 2={2=Name2}, 3={3=Name1}, 4={4=Name2}}

		final Map<Integer, Map<Integer, List<Book>>> collect1 =
				books.stream().collect(Collectors.groupingBy(Book::getId, Collectors.groupingBy(Book::getId)));

		System.out.println(collect1);
		// {1={1=[id=1,name=Name1]}, 2={2=[id=2,name=Name2]}, 3={3=[id=3,name=Name1]}, 4={4=[id=4,name=Name2]}}

		final Map<Integer, List<String>> collect2 =
				books.stream().collect(Collectors.groupingBy(Book::getId, Collectors.mapping(Book::getName, Collectors.toList())));

		System.out.println(collect2);
		// {1=[Name1], 2=[Name2], 3=[Name1], 4=[Name2]}

		final Map<Integer, Long> collect3 =
				books.stream().collect(Collectors.groupingBy(Book::getId, Collectors.mapping(Book::getId, Collectors.counting())));

		System.out.println(collect3);
		// {1=1, 2=1, 3=1, 4=1}
	}

	private static void groupingByFunctionSupplierCollector(){
		final TreeMap<Integer, List<Book>> collect = books.stream().collect(Collectors.groupingBy(Book::getId, TreeMap::new, Collectors.toList()));

		System.out.println(collect);
		// {1=[id=1,name=Name1], 2=[id=2,name=Name2], 3=[id=3,name=Name1], 4=[id=4,name=Name2]}

		final LinkedHashMap<Integer, List<Book>> collect1 =
				books.stream().collect(Collectors.groupingBy(Book::getId, LinkedHashMap::new, Collectors.toList()));

		System.out.println(collect1);
		// {1=[id=1,name=Name1], 2=[id=2,name=Name2], 3=[id=3,name=Name1], 4=[id=4,name=Name2]}
	}
}


