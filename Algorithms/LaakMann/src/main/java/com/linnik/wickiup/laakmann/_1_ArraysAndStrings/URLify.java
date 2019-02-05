package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

/**
 * =====================================================================
 * URLify: Write a method to replace all spaces in a string with '%20'.
 * <p>
 * EXAMPLE
 * <p>
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 * =====================================================================
 */
public class URLify {

    public String replaceSpaces(String str) {
        char[] chars = str.trim().toCharArray();

        StringBuilder result = new StringBuilder();
        boolean wasSpace = false;
        for (char c : chars) {
            if (c == ' ' && !wasSpace) {
                result.append("%20");
                wasSpace = true;
            } else if (c != ' ') {
                wasSpace = false;
                result.append(c);
            }
        }
        return result.toString();
    }

    public String replace(char[] str) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                flag = true;
            }
            if (flag) {
                if (str[i] == ' ') {
                    sb.append('0');
                    sb.append('2');
                    sb.append('%');
                    flag = false;
                } else {
                    sb.append(str[i]);
                }

            }
        }
        return sb.reverse().toString();
    }

}
