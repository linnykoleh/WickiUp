package com.linnyk.ocp.inner;

public class TestOuterStatic {

	static class InnerStatic{

	}

	public static void checkItStatic(){
		new InnerStatic();

		new TestOuterStatic.InnerStatic();

		final TestOuterStatic testOuter = new TestOuterStatic();
//		testOuter.new InnerStatic(); Qualified new of static class

//		new TestOuterStatic().new InnerStatic(); Qualified new of static class
	}
}
