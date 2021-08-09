package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagramsApp
{
    public static void main(String[] args) {
        String[] words = {"yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"};
        String[] words2 = {"cinema", "a", "flop", "iceman", "meacyne", "lofp", "olfp"};
        List<String> wordsList = new ArrayList<>(Arrays.asList(words2));

        System.out.println(groupAnagrams(wordsList));
    }


    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        List<List<String>> anagramsList = new ArrayList<>();
        List<String> tempAnagrams = new ArrayList<>();
        int i = 1;

        while (!words.isEmpty()) {
            tempAnagrams.add(words.get(0));

            while (i < words.size()) {
                if (sortString(words.get(0)).equals(sortString(words.get(i)))) {
                    tempAnagrams.add(words.get(i));
                    words.remove(i);
                    i--;
                }
                i++;
            }

            String[] string = tempAnagrams.toArray(new String[0]);
            words.remove(0);
            i = 1;
            anagramsList.add(Arrays.asList(string));
            tempAnagrams.clear();
        }

        return anagramsList;
    }

    public static String sortString(String str) {
        char[] strChars = str.toCharArray();
        Arrays.sort(strChars);
        return new String(strChars);
    }
}
