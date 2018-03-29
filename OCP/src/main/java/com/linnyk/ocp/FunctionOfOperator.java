package com.linnyk.ocp;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class FunctionOfOperator {

	private static int operate(IntUnaryOperator iuo){
		return iuo.applyAsInt(5);
	}

	public static void main(String[] args) {

		IntFunction<IntUnaryOperator> fo = a -> {
			System.out.println(a); //20
			return b -> {
				System.out.println(b); //5
				return a - b;
			};
		};

		int x = operate(fo.apply(20));
		System.out.println(x); //15
	}
}
