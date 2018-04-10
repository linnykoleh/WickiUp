package com.linnyk.ocp;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	static BookStore bookStore = new BookStore();

	public static void main(String[] args) {
		Book book = new Book();
		book.setIsbn("111");

		bookStore.addBook(book, 10);
		System.out.println(bookStore.getNumberOfCopies(book));

		book = new Book();
		book.setIsbn("111");

		System.out.println(bookStore.getNumberOfCopies(book));

		/*
			10
			Exception in thread "main" java.lang.NullPointerException
				at com.linnyk.ocp.BookStore.getNumberOfCopies(HashMapTest.java:46)
				at com.linnyk.ocp.HashMapTest.main(HashMapTest.java:20)
		*/

	}
}

class Book{

	private String title, isbn;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean equals(Object o){
		return (o instanceof Book && ((Book)o).isbn.equals(this.isbn));
	}
}

class BookStore {

	Map<Book, Integer> map = new HashMap<>();

	int getNumberOfCopies(Book b){
		return map.get(b);
	}

	public void addBook(Book b, int number){
		map.put(b, number);
	}
}
