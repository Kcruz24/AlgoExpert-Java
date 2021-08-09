package FirstNonRepeatingCharacter;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterApp
{
    public static void main(String[] args) {
        String string = "acdcabf";

        System.out.println(firstNonRepeatingCharacterOptimal(string));
    }

    // Brute force solution
    // O(N^2) time | O(1) space
    public static int firstNonRepeatingCharacter(String string) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j) && i != j) {
                    count++;
                }
            }

            if (count == 0) {
                return i;
            }

            count = 0;
        }

        return -1;
    }

    // Optimal solution
    // O(N) time | O(1) space
    public static int firstNonRepeatingCharacterOptimal(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (map.get(character) == 1) {
                return i;
            }
        }

        return -1;
    }
}
