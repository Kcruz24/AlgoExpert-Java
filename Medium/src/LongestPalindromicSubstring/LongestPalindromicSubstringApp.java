package LongestPalindromicSubstring;

public class LongestPalindromicSubstringApp
{
    public static void main(String[] args) {
        String str = "abcdefghfedcbaa";
        String str2 = "z234a5abbbba54a32z";
        String str3 = "abaxyzzyxf";
        String str4 = "abcdefgaaedceab";

        // System.out.println(str.substring(str.length() - 2, str.length()));
        System.out.println(longestPalindromicSubstring(str4));
    }

    public static String longestPalindromicSubstring(String str) {
        int left = 1, middle = 1, right = 1;
        int longestPalindrome = 0, counter = 0;
        String palindromicSubstring = "";

        if (str.length() == 1)
            return str;

        while (middle < str.length() - 1) {
            boolean mid = str.charAt(middle) == str.charAt(middle + 1);
            // Handles the case when the palindrome is even
            if (left - 1 >= 0 && right + 2 < str.length() && mid && str.charAt(left - 1) == str.charAt(right + 2)) {
                right++;
                counter++;
            }

            // Handles the case when the palindrome is odd
            while (left - 1 >= 0 && right + 1 < str.length() && str.charAt(left - 1) == str.charAt(right + 1)) {
                counter++;
                left--;
                right++;
            }

            // Handles the edge case when there is only one palindrome of two letters in the string.
            if (mid && counter == 0) {
                counter++;
                right++;
            }

            if (counter > longestPalindrome) {
                longestPalindrome = counter;
                palindromicSubstring = str.substring(left, right + 1);
            }

            middle++;
            left = middle;
            right = middle;
            counter = 0;
        }

        return palindromicSubstring;
    }
}
