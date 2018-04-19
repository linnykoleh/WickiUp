package com.linnyk.ocp.stream_collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Mapping2 {

	public static void main(String[] args) {
		List<String> ohMy = Arrays.asList("lions", "tigers", "bears");

		final Map<Integer, List<Character>> collect = ohMy.stream().collect(Collectors.groupingBy(String::length,
				Collectors.mapping(s -> s.charAt(0), Collectors.toList())));

		System.out.println(collect); // {5=[l, b], 6=[t]}

		final Map<Integer, Optional<Character>> collect1 = ohMy.stream().collect(Collectors.groupingBy(String::length,
				Collectors.mapping(s -> s.charAt(0), Collectors.minBy(Character::compareTo))));

		System.out.println(collect1); // {5=Optional[b], 6=Optional[t]}
	}
}
