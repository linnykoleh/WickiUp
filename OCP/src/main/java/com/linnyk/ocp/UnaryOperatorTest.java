package com.linnyk.ocp;

import java.util.function.LongUnaryOperator;

public class UnaryOperatorTest {

	public static void main(String[] args) {
		LongUnaryOperator luo = l -> l * 2;
		long result = luo.compose(luo).applyAsLong(3);
		System.out.println(result); // 12 = (2 * 2 * 3)

		LongUnaryOperator luo1 = l1 -> l1 * 3;
		long result1 = luo1.compose(luo1).applyAsLong(3);
		System.out.println(result1); // 27 = (3 * 3 * 3)

		LongUnaryOperator luo2 = l2 -> l2 * 4;
		long result2 = luo2.compose(luo2).applyAsLong(3);
		System.out.println(result2); // 48 (4 * 4 * 3)
	}
}
