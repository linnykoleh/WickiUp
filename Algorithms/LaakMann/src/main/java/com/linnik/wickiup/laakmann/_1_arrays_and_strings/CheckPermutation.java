package com.linnik.wickiup.laakmann._1_arrays_and_strings;

import java.util.Arrays;

/**
 *======================================================================================================
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other
 *
 * If two strings are permutations, then we know they have the same characters, but in different orders.
 * ======================================================================================================
 */
public class CheckPermutation {

    /**
     * Solution #1: Sort the strings.
     * <p>
     * Sorting the strings will put the characters from two permutations in the same order.
     * We just need to compare the sorted versions of the strings.
     */
    boolean permutation1(String srt1, String str2) {
        if (srt1.length() != str2.length()) {
            return false;
        }
        return sort(srt1).equals(sort(str2));
    }

    private String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    /**
     * Solution #2: Check if the two strings have identical character counts.
     */
    boolean permutation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] letters = new int[128];
        char[] s_array = str1.toCharArray();
        for (char c : s_array) {
            final int letter = letters[c];
            letters[c] = letter + 1;
        }
        for (int i = 0; i < str2.length(); i++) {
            int c = (int) str2.charAt(i);
            final int letter = letters[c];
            letters[c] = letter - 1;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
