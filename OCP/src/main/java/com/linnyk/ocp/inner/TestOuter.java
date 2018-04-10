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

}
