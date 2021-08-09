package ReverseWordsInString;

import java.util.ArrayList;

public class ReverseWordsInStringApp
{
    public static void main(String[] args) {
        String str = "AlgoExpert is the Best!";
        System.out.println(reverseWordsInString(str));
    }

    public static String reverseWordsInString(String string) {
        var words = new ArrayList<String>();
        var reverseWords = new StringBuilder();
        int mark = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                words.add(string.substring(mark, i));
                mark = i + 1;
            }
        }

        words.add(string.substring(mark));

        for (int i = words.size() - 1; i > 0; i--) {
            reverseWords.append(words.get(i)).append(' ');
        }

        reverseWords.append(words.get(0));

        return reverseWords.toString();
    }
}
