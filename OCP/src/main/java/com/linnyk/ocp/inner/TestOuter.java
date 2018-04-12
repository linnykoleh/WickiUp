package com.linnyk.ocp.inner;

public class TestOuter {

	class Inner{

	}

	public void checkIt() {
		new Inner();

		new TestOuter.Inner();

		final TestOuter testOuter = new TestOuter();
		testOuter.new Inner();

		new TestOuter().new Inner();

	}

	public static void main(String[] args) {
//		new TestOuter.Inner(); Compilation error Cannot be referenced from a static context
		new TestOuter().new Inner();

		// Внутри статического метода мы не можем создать ссылку внутреннего класса
		// без ссылки на внешний класс
	}

}
