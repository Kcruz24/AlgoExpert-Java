package GenerateDocument;

import java.util.*;

public class GenerateDocumentApp
{
    public static void main(String[] args) {
        String document = "hello";
        String characters = "aheaolabbhb";

        System.out.println(generateDocument(characters, document));
    }

    public static boolean generateDocument(String characters, String document) {
        // Write your code here.
        Map<String, Integer> chars = countChars(characters);
        Map<String, Integer> doc = countChars(document);
        List<String> charsArray = new ArrayList<>();
        List<String> charsDocArray = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        List<Integer> integersDoc = new ArrayList<>();
        int counter = 0;

        for (String str : chars.keySet()) {
            charsArray.add(str);
            integers.add(chars.get(str));
        }

        for (String str : doc.keySet()) {
            charsDocArray.add(str);
            integersDoc.add(doc.get(str));
        }

        for (int i = 0; i < doc.size(); i++) {
            for (int j = 0; j < chars.size(); j++) {
                if (charsDocArray.get(i).equals(charsArray.get(j)) && integers.get(j) >= integersDoc.get(i)) {
                    counter++;
                }
            }
        }

        return counter == doc.size();
    }

    public static Map<String, Integer> countChars(String str) {
        Map<String, Integer> charList = new LinkedHashMap<>();
        Map<Character, Integer> charSet = new LinkedHashMap<>();
        char[] charString = str.toCharArray();
        Arrays.sort(charString);
        String sorted = new String(charString);

        for (int i = 0; i < sorted.length(); i++) {
            charSet.put(sorted.charAt(i), i);
        }

        int counter = 0;

        for (int i = 0; i < charSet.size(); i++) {
            for (int j = 0; j < sorted.length(); j++) {
                if (charSet.keySet().toArray()[i].equals(sorted.charAt(j))) {
                    counter++;
                }
            }

            charList.put(charSet.keySet().toArray()[i].toString(), counter);
            counter = 0;
        }

        return charList;
    }
}
