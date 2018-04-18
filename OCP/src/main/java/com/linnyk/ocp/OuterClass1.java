package com.linnyk.ocp;

public class OuterClass1 {

	static int y = 0;

	public static void main(String[] args) {

		abstract class A {
			public abstract int calc(int x);
		}

		A a = new A() {

			@Override
			public int calc(int x) {
				return x * y;
			}

			public void print(int x){
				System.out.println(calc(x));
			}
		};

		System.out.println(a.calc(2)); // 0
	}

	static class Nested{

		static class NestedNested{

		}

		class InnerNested{

		}
	}
}
