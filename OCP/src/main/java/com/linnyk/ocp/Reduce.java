package com.linnyk.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

	public static void main(String[] args) {
		List<String> letters = Arrays.asList("j", "a", "v", "a");

		String word = letters.stream().reduce("", (a, b) -> a.concat(b));
		System.out.println(word); //java

		String word1 = letters.stream().collect(Collectors.joining());
		System.out.println(word1); //java
	}


}
