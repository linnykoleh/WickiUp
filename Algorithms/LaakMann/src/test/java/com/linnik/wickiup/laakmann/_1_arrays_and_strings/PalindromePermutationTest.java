package com.linnik.wickiup.laakmann._1_arrays_and_strings;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePermutationTest {

	private final PalindromePermutation palindromePermutation = new PalindromePermutation();

	@Test
	public void testTrue() {
		final boolean actual = palindromePermutation.isPermutationOfPalindrome("Tact Coa");

		Assert.assertTrue(actual);
	}

	@Test
	public void testTrue1() {
		final boolean actual = palindromePermutation.isPermutationOfPalindrome("aabbcdd");

		Assert.assertTrue(actual);
	}

	@Test
	public void testFalse() {
		final boolean actual = palindromePermutation.isPermutationOfPalindrome("aabcdd");

		Assert.assertFalse(actual);
	}
}
