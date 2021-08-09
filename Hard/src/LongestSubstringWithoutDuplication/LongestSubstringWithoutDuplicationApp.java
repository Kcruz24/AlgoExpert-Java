package LongestSubstringWithoutDuplication;

import java.util.*;

public class LongestSubstringWithoutDuplicationApp
{
    public static void main(String[] args) {
        String test = "abcdeabcdefc";

        System.out.println(longestSubstringWithoutDuplication2(test));
    }

    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        StringBuilder strBld = new StringBuilder();
        String longestSubstring = "";
        int i = 0;

        while (i < str.length()) {
            if (strBld.indexOf(String.valueOf(str.charAt(i))) < 0) {
                strBld.append(str.charAt(i));
                i++;
            } else {
                if (strBld.length() > longestSubstring.length()) {
                    longestSubstring = strBld.toString();
                    strBld.delete(0, strBld.length());
                }
            }
        }

        if (longestSubstring.length() == 0)
            longestSubstring = strBld.toString();

        return longestSubstring;
    }

    public static String longestSubstringWithoutDuplication2(String str) {
        // Write your code here
        List<Character> chars = new ArrayList<>();
        StringBuilder strBld = new StringBuilder();
        String longestSubstring = "";
        int i = 0;

        while (i < str.length()) {
            if (chars.contains(str.charAt(i))) {
                for (Character letter : chars)
                    strBld.append(letter);

                if (strBld.length() > longestSubstring.length())
                    longestSubstring = strBld.toString();

                chars.clear();
                strBld.delete(0, strBld.length());
            } else {
                chars.add(str.charAt(i));
                i++;
            }
        }

        if (longestSubstring.length() == 0) {
            for (Character letter : chars)
                strBld.append(letter);

            longestSubstring = strBld.toString();
        }


        return longestSubstring;
    }
}
