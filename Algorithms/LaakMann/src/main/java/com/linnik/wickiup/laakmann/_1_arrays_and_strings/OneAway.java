package com.linnik.wickiup.laakmann._1_arrays_and_strings;

/**
 * ==================================================================================================================================
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 * ===================================================================================================================================
 * What does it mean for two strings to be one insertion, replacement, or removal away from each other?
 * <p>
 * - Replacement: Consider two strings, such as "bale" and "pale", that are one replacement away. Yes, that
 * 				  does mean that you could replace a character in "bale" to make "pale".
 * 				  But more precisely, it means that they are different only in one place.
 * - Insertion: The strings "apple" and "aple' are one insertion away.
 * 				This means that if you compared the strings, they would be identical-except for a shift at some point in the strings.
 * - Removal: The strings "apple" and "aple" are also one removal away, since removal is just the inverse of insertion
 * ====================================================================================================================================
 */
public class OneAway {

	boolean oneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsertRemove(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsertRemove(second, first);
		}
		return false;
	}

	/*Length is the same*/
	private boolean oneEditReplace(String sl, String s2) {
		boolean foundDifference = false;
		for (int i = 0; i < sl.length(); i++) {
			if (sl.charAt(i) != s2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}

	/*Length is different*/
	private boolean oneEditInsertRemove(String sl, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < sl.length()) {
			if (sl.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

}
