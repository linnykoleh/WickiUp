package com.linnik.wickiup.laakmann._2_linked_lists;

import org.junit.Assert;
import org.junit.Test;

import com.linnik.wickiup.laakmann._2_linked_lists.structures.LinkedList;

public class PalindromeTest {

	@Test
	public void testIsPalindrome() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.append(0);
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(1);
		linkedList.append(0);

		Palindrome palindrome = new Palindrome();

		final boolean actual = palindrome.isPalindrome(linkedList.head);

		Assert.assertTrue(actual);
	}

	@Test
	public void testIsNotPalindrome() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.append(0);
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(1);
		linkedList.append(1);

		Palindrome palindrome = new Palindrome();

		final boolean actual = palindrome.isPalindrome(linkedList.head);

		Assert.assertFalse(actual);
	}
}
