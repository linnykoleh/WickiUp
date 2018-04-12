package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.List;

public class AllMatch {

	public static void main(String[] args) {
		final List<String> list = Arrays.asList("Java EE", "JC#", "JPython");
		boolean flag = list.stream().allMatch(str -> {
			System.out.println("Testing : " + str);
			return str.startsWith("J");
		});
		System.out.println(flag);
		// Testing : Java EE
		// Testing : JC#
		// Testing : JPython
		// true

		final List<String> list1 = Arrays.asList("Java EE", "C#", "JPython");
		boolean flag1 = list1.stream().allMatch(str -> {
			System.out.println("Testing : " + str);
			return str.startsWith("J");
		});
		System.out.println(flag1);
		// Testing : Java EE
		// Testing : C#
		// false

		final List<String> list2 = Arrays.asList("Java EE", "JC#", "Python");
		boolean flag2 = list2.stream().allMatch(str -> {
			System.out.println("Testing : " + str);
			return str.startsWith("J");
		});
		System.out.println(flag2);
		// Testing : Java EE
		// Testing : JC#
		// Testing : Python
		// false
	}

}
