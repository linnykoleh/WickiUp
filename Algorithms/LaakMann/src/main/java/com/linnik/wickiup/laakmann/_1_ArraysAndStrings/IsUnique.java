package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

public class IsUnique {

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
