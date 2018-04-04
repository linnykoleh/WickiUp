package com.linnyk.ocp;

import java.util.stream.IntStream;

public class StreamRange {

	public static void main(String[] args) {
		final Object v1 = IntStream.rangeClosed(10, 15)
				.boxed()
				.filter(x -> x > 12)
				.parallel()
				.findAny();

		final Object v2 = IntStream.rangeClosed(10, 15)
				.boxed()
				.filter(x -> x > 12)
				.sequential()
				.findAny();

		System.out.println(" " + v2);
		//Optional[13] Optional[13]
		//Optional[14] Optional[13]
		//Optional[15] Optional[13]
	}
}
