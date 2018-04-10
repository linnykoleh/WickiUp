package com.linnyk.ocp;

import java.util.stream.Stream;

public class ForEachOrdered {

	public static void main(String[] args) {
		Stream.of("AAA","BBB","CCC").parallel().forEach(s->System.out.println("Output:"+s));

//		Output:BBB
//		Output:AAA
//		Output:CCC

		Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output:" + s));

//		Output:AAA
//		Output:BBB
//		Output:CCC
	}
}
