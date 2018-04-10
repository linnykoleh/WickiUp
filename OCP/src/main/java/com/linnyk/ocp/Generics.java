package com.linnyk.ocp;

import java.util.ArrayList;
import java.util.List;

public class Generics {

	private static <E extends CharSequence> List<? super E> doIt(List<E> nums) {
		return nums;
	}

	public static void testIt() {
		ArrayList<String> strings = new ArrayList<>();
		final List<? super String> objects = doIt(strings);
	}

	public static void testIt2() {
		List<String> strings = new ArrayList<>();
		final List<? super String> objects = doIt(strings);
	}

	public static void testIt3() {
		List<CharSequence> strings = new ArrayList<>();
		final List<? super CharSequence> objects = doIt(strings);
	}

	public static void testIt4() {
		List<CharSequence> strings = new ArrayList<>();
		final List<? super CharSequence> objects = doIt(strings);
	}

	public static void testIt5() {
		List<CharSequence> strings = new ArrayList<>();
		final List objects = doIt(strings);
	}

	public static void testIt6() {
		ArrayList<CharSequence> strings = new ArrayList<>();
		final List objects = doIt(strings);
	}

	public static void testIt7() {
		ArrayList<StringBuilder> strings = new ArrayList<>();
		final List objects = doIt(strings);
	}

	public static void testIt8() {
		List<StringBuilder> strings = new ArrayList<>();
		final List objects = doIt(strings);
	}
}
