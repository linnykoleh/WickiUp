package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

import java.util.Arrays;

/**
 * =================================================================================================
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees.
 * |---|---|---|---|
 * |---|---|---|---|
 * |---|---|---|---|
 * |---|---|---|---|
 * |---|---|---|---|
 * A better way to do this is to implement the swap index by index. In this case, we do the following:
 * for i = 0 to n
 * temp= top[i];
 * top[i] = left[i]
 * left[i] = bottom[i]
 * bottom[i] = right[i]
 * right[i] = temp
 * =================================================================================================
 */
public class RotateMatrix {

	/**
	 * This algorithm is O (N2)
	 */
	public boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) {
			return false;
		}
		int length = matrix.length;
		for (int layer = 0; layer < length / 2; layer++) {

			int last = length - 1 - layer;

			for (int i = layer; i < last; i++) {
				int offset = i - layer;

				int top = matrix[layer][i]; // save top

				// left -> top
				matrix[layer][i] = matrix[last - offset][layer];

				// bottom -> left
				matrix[last - offset][layer] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right<- saved top

				for (int[] mas : matrix) {
					System.out.println(Arrays.toString(mas));
				}
				System.out.println("-----------------");
			}

		}
		return true;
	}

	// [1, 2, 3, 4]
	// [1, 2, 3, 4]
	// [1, 2, 3, 4]
	// [1, 2, 3, 4]

	// [1, 2, 3, 1]
	// [1, 2, 3, 4]
	// [1, 2, 3, 4]
	// [4, 2, 3, 4]

	// [1, 1, 3, 1]
	// [1, 2, 3, 2]
	// [3, 2, 3, 4]
	// [4, 2, 4, 4]

	// [1, 1, 1, 1]
	// [2, 2, 3, 2]
	// [3, 2, 3, 3]
	// [4, 4, 4, 4]

	// [1, 1, 1, 1]
	// [2, 2, 2, 2]
	// [3, 3, 3, 3]
	// [4, 4, 4, 4]
}

