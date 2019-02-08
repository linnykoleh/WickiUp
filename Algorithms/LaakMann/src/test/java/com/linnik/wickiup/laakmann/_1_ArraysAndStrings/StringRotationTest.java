package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class StringRotationTest {

	private final StringRotation stringRotation = new StringRotation();

	@Test
	public void test() {
		String s1 = "waterbottle!";
		String s2 = "erbottle!wat";

		final boolean isRotation = stringRotation.isRotation(s1, s2);

		Assert.assertTrue(isRotation);
	}

}
