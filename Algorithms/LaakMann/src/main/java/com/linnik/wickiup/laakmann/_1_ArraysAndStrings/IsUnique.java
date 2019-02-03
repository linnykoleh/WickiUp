package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 */
public class IsUnique {

    /**
     * - The time complexity for this code is O(n), where n is the length of the string.
     * - The space complexity is O(1).
     * <p>
     * See ASCII table at http://www.asciitable.com/ for more information
     */
    boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] chars = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (chars[val]) {//Already found this char in string
                return false;
            }
            chars[val] = true;
        }
        return true;
    }
}
