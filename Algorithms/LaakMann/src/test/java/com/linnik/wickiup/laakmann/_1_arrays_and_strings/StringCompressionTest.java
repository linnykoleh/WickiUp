package com.linnik.wickiup.laakmann._1_arrays_and_strings;

import org.junit.Assert;
import org.junit.Test;

public class StringCompressionTest {

	private final StringCompression stringCompression = new StringCompression();

	@Test
	public void test() {
		String expected = "a2b1c5a3";

		String actual = stringCompression.compress("aabcccccaaa");

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		String expected = "bcdooo";

		String actual = stringCompression.compress("bcdooo");

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		String expected = "b1c1d1o7";

		String actual = stringCompression.compress("bcdooooooo");

		Assert.assertEquals(expected, actual);
	}
}
