package com.linnik.wickiup.patterns._2_structural._1_adapter.live;

import java.util.Arrays;
import java.util.List;

/**
 * @author LinnykOleh
 */
public class Live {

	public static void main(String[] args) {
		final Integer[] arraysOfInts = new Integer[] {42, 43, 44};
		final List<Integer> list = Arrays.asList(arraysOfInts);

		System.out.println(arraysOfInts);
		System.out.println(list);
	}
}
