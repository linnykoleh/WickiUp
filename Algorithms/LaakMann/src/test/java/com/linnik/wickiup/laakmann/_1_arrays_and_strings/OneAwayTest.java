package com.linnik.wickiup.laakmann._1_arrays_and_strings;

import org.junit.Assert;
import org.junit.Test;

public class OneAwayTest {

	private final OneAway oneAway = new OneAway();

	@Test
	public void test(){
		final boolean actual = oneAway.oneEditAway("pale", "pal");

		Assert.assertTrue(actual);
	}

	@Test
	public void test2(){
		final boolean actual = oneAway.oneEditAway("bale", "pale");

		Assert.assertTrue(actual);
	}

	@Test
	public void test3(){
		final boolean actual = oneAway.oneEditAway("apple", "aple");

		Assert.assertTrue(actual);
	}

	@Test
	public void test4(){
		final boolean actual = oneAway.oneEditAway("apple", "able");

		Assert.assertFalse(actual);
	}

	@Test
	public void test5(){
		final boolean actual = oneAway.oneEditAway("aple", "able");

		Assert.assertTrue(actual);
	}

	@Test
	public void test6(){
		final boolean actual = oneAway.oneEditAway("apple", "abble");

		Assert.assertFalse(actual);
	}

}
