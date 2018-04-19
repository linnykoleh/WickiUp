package com.linnyk.ocp.inner;

public class InnerInStaticMethod {

	static int outerStatic;
	int outer;

	public static void main(String[] args) {

		int outer = 1;
		outer++;
		class Inner {
			public void myM(int a) {
				int b = ++a;
				b++;

				System.out.println(outerStatic);
//				System.out.println(outer); Compilation error Reference from a static context
				System.out.println(args);
				System.out.println(a);
				System.out.println(b);
//				System.out.println(outer); Compilation error Final or Effectively final
			}

//			public static void myM() { } Compilation error No static
//			static int a; Compilation error No static
		}

	}
}
