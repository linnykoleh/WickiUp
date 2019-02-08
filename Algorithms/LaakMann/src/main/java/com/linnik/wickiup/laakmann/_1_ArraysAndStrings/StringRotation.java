package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

/**
 * =======================================================================================================
 * String Rotation: Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring
 * of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
 * call to i5Sub5tring (e.g., "waterbottle" is a rotation of"erbottlewat").
 * The runtime of is Rotation isO(N).
 * =======================================================================================================
 */
public class StringRotation {

	boolean isRotation(String s1, String s2) {
		int len = s1.length();

		if (len == s2.length() && len > 0) {
			String slsl = s1 + s1;  // Will be `waterbottle!waterbottle!`
			return isSubstring(slsl, s2);
		}
		return false;
	}

	private boolean isSubstring(String s1, String s2) {
		//Check if `waterbottle!waterbottle!` contains `erbottle!wat`
		return s1.contains(s2);
	}
}
