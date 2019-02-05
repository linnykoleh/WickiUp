package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class RotateMatrixTest {

	private final RotateMatrix rotateMatrix = new RotateMatrix();

	@Test
	public void test() {
		int[][] actual = {
				{1, 2, 3, 4},
				{1, 2, 3, 4},
				{1, 2, 3, 4},
				{1, 2, 3, 4}
		};

		int[][] expected = {
				{1, 1, 1, 1},
				{2, 2, 2, 2},
				{3, 3, 3, 3},
				{4, 4, 4, 4}
		};

		final boolean isRotated = rotateMatrix.rotate(actual);

		Assert.assertTrue(isRotated);
		Assert.assertArrayEquals(actual, expected);
	}
}

