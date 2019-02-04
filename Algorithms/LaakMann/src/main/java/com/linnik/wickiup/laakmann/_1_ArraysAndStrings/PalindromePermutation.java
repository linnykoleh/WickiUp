package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

/**
 * =========================================================================================================
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of
 * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 * dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat'; "atco eta·; etc.)
 * ==========================================================================================================
 * What does it take to be able to write a set of characters the same way forwards and backwards? We need to
 * have an even number of almost all characters, so that half can be on one side and half can be on the other
 * side. At most one character (the middle character) can have an odd count.
 * For example, we know "tactcoapapa" is a permutation of a palindrome because it has two Ts, four As, two
 * Cs, two Ps, and one 0. That O would be the center of all possible palindromes.
 * ==========================================================================================================
 * A palindrome is a string that is the same forwards and backwards.
 * Therefore, to decide if a string is a permutation
 * of a palindrome, we need to know if it can be written such that it's the same forwards and backwards
 * ==========================================================================================================
 */
public class PalindromePermutation {

	//======================================================================
	// This algorithm takes O(N) time, where N is the length of the string.
	//======================================================================
	boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}

	private int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[128];
		for (char c : phrase.toLowerCase().toCharArray()) {
			if (c == ' ') {
				continue;
			}
			table[c]++;
		}
		return table;
	}

	private boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

}
