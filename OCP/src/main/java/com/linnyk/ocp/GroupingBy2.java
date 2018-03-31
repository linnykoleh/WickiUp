package com.linnyk.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy2 {

	public static void main(String[] args) {
		List<Book> books = Arrays.asList(
				new Book("There is a hippy on the highway", "Thriller", "James Hadley Chase"),
				new Book("Coffin from Hongkong", "Thriller", "James Hadley Chase"),
				new Book("The Client", "Thriller", "John Grisham"),
				new Book("Gone with the wind", "Fiction", "Margaret Mitchell")
		);
		Map<String, Map<String, List<Book>>> classified = books.stream().collect(
				Collectors.groupingBy(Book::getGenre, Collectors.groupingBy(Book::getAuthor) ));

		System.out.println(classified);

		/*
		{Thriller={
		  James Hadley Chase=[{title='There is a hippy on the highway', genre='Thriller', author='James Hadley Chase'},
		                      {title='Coffin from Hongkong', genre='Thriller', author='James Hadley Chase'}],
		  John Grisham=[{title='The Client', genre='Thriller', author='John Grisham'}]},
		Fiction={
		   Margaret Mitchell=[{title='Gone with the wind', genre='Fiction', author='Margaret Mitchell'}]}}
		*/
	}

	static class Book{

		String title;
		String genre;
		String author;

		public Book(String title, String genre, String author) {
			this.title = title;
			this.genre = genre;
			this.author = author;
		}

		public String getTitle() {
			return title;
		}

		public String getGenre() {
			return genre;
		}

		public String getAuthor() {
			return author;
		}

		@Override
		public String toString() {
			return "{" +
					"title='" + title + '\'' +
					", genre='" + genre + '\'' +
					", author='" + author + '\'' +
					'}';
		}
	}
}
