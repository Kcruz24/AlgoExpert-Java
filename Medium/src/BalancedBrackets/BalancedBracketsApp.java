package BalancedBrackets;

import java.util.Stack;

public class BalancedBracketsApp
{
    public static void main(String[] args) {
        String bracket = "([])(){}(())()";
        System.out.println(bracket.indexOf('['));
        System.out.println(balancedBrackets(bracket));
    }

    public static boolean balancedBrackets(String str) {
        Stack<Character> brackets = new Stack<>();

        if (hasUnevenBrackets(str))
            return false;

        String openingBrackets = "({[";
        String closingBrackets = ")}]";

        char parenthesisOpen = '(';
        char parenthesisClose = ')';
        int parenthesisCount = 0;

        char curlyOpen = '{';
        char curlyClose = '}';
        int curlyCount = 0;

        char squareOpen = '[';
        char squareClose = ']';
        int squareCount = 0;

        int i = 0;

        while (i < str.length()) {

            if (!brackets.isEmpty()) {
                if (brackets.peek() == parenthesisOpen)
                    parenthesisCount++;

                if (brackets.peek() == curlyOpen)
                    curlyCount++;

                if (brackets.peek() == squareOpen)
                    squareCount++;
            }

            if (isBracketClosed(str.charAt(i)) && squareCount > 0) {
                if (str.charAt(i) == squareClose)
                    brackets.pop();
                else
                    return false;
            }

            if (isBracketClosed(str.charAt(i)) && curlyCount > 0) {
                if (str.charAt(i) == curlyClose)
                    brackets.pop();
                else
                    return false;
            }

            if (isBracketClosed(str.charAt(i)) && parenthesisCount > 0) {
                if (str.charAt(i) == parenthesisClose)
                    brackets.pop();
                else
                    return false;
            }

            if (isBracketOpen(str.charAt(i)))
                brackets.push(str.charAt(i));

            parenthesisCount = 0;
            curlyCount = 0;
            squareCount = 0;
            i++;
        }

        return brackets.isEmpty();
    }

    public static boolean hasUnevenBrackets(String str) {
        int openCount = 0, closedCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (isBracketOpen(str.charAt(i)))
                openCount++;

            if (isBracketClosed(str.charAt(i)))
                closedCount++;
        }

        return openCount != closedCount;
    }

    public static boolean isBracketOpen(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    public static boolean isBracketClosed(char bracket) {
        return bracket == ')' || bracket == '}' || bracket == ']';
    }
}
