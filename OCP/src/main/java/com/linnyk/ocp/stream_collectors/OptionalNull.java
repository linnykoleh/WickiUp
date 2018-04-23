package com.linnyk.ocp.stream_collectors;

import java.util.Optional;

public class OptionalNull {

	public static void main(String[] args) {

	}

	private static void _1() {
		final Optional<Object> o = Optional.of(null); //NullPointerException

		Optional<String> opt = Optional.ofNullable(null); //вернёт Optional.empty
		System.out.println(opt.get()); //NoSuchElementException
	}

	private static void _2(){
		Optional<String> optional = Optional.empty();
		if (optional.isPresent()) {
			System.out.println("Yes");
		}
		else {
			optional.of("Java");
		}

		System.out.println(optional.orElse("Unknown"));
		// Unknown
	}


}
