package PalindromeCheck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckApp
{
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdcba"));
    }

    // My Solution
    // O(n) time | O(n) space
    public static boolean isPalindrome(String str) {
        // Write your code here.
        // "abcdcba"
        Stack<Character> stringStack = new Stack<>();
        Queue<Character> stringQueue = new LinkedList<>();
        char[] chars = str.toCharArray();
        int count = 0;

        for (char aChar : chars) {
            stringStack.push(aChar);
            stringQueue.add(aChar);
        }

        for(int i = 0; i < str.length(); i++) {
            char queue = stringQueue.remove();
            char stack = stringStack.pop();

            if (queue == stack)
                count++;
        }
        return count == str.length();
    }
}
