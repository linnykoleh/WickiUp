package com.linnyk.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {
		List<Course> s1 = Arrays.asList(
				new Course("OCAJP", "Java"),
				new Course("OCAJP", "Java"),
				new Course("C#", "C#"),
				new Course("OCEJPA#", "Java")
		);

		s1.stream().collect(Collectors.groupingBy(Course::getCategory)).
				forEach((k, v) -> System.out.println(v));
		/*
		    [{id='C#', category='C#'}]
			[{id='OCAJP', category='Java'}, {id='OCAJP', category='Java'}, {id='OCEJPA#', category='Java'}]
		*/
	}

	static class Course{
		String id;
		String category;

		public Course(String id, String category) {
			this.id = id;
			this.category = category;
		}

		public String getId() {
			return id;
		}

		public String getCategory() {
			return category;
		}

		@Override
		public String toString() {
			return "{" +
					"id='" + id + '\'' +
					", category='" + category + '\'' +
					'}';
		}
	}
}
