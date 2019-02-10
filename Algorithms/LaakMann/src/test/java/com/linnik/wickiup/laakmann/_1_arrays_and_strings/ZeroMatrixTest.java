package com.linnik.wickiup.laakmann._1_arrays_and_strings;

import org.junit.Assert;
import org.junit.Test;

public class ZeroMatrixTest {

	private final ZeroMatrix zeroMatrix = new ZeroMatrix();

	@Test
	public void test() {
		int[][] actual = {
				{1, 2, 3, 4},
				{1, 0, 3, 4},
				{1, 2, 3, 4},
				{1, 2, 3, 4}
		};

		int[][] expected = {
				{1, 0, 3, 4},
				{0, 0, 0, 0},
				{1, 0, 3, 4},
				{1, 0, 3, 4}
		};

		zeroMatrix.setZeros(actual);

		Assert.assertArrayEquals(actual, expected);
	}

	@Test
	public void test1() {
		int[][] actual = {
				{1, 2, 3, 4, 5},
				{1, 0, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 0, 5},
		};

		int[][] expected = {
				{1, 0, 3, 0, 5},
				{0, 0, 0, 0, 0},
				{1, 0, 3, 0, 5},
				{0, 0, 0, 0, 0},
		};

		zeroMatrix.setZeros(actual);

		Assert.assertArrayEquals(actual, expected);
	}
}
