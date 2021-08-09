package CaesarCipherEncryptor;

import java.util.HashMap;
import java.util.Map;

public class CaesarCipherEncryptorApp
{
    public static void main(String[] args) {

        System.out.println(caesarCypherEncryptor("xyz", 2));
    }

    public static String caesarCypher(String str, int key) {
        Map<Character, Integer> alphabets = new HashMap<>() {{
            put('a', 1);
            put('b', 2);
            put('c', 3);
            put('d', 4);
            put('e', 5);
            put('f', 6);
            put('g', 7);
            put('h', 8);
            put('i', 9);
            put('j', 10);
            put('k', 11);
            put('l', 12);
            put('m', 13);
            put('n', 14);
            put('o', 15);
            put('p', 16);
            put('q', 17);
            put('r', 18);
            put('s', 19);
            put('t', 20);
            put('u', 21);
            put('v', 22);
            put('w', 23);
            put('x', 24);
            put('y', 25);
            put('z', 0);
        }};

        StringBuilder stringBuilder = new StringBuilder();
        char[] charList = str.toCharArray();
        int[] letterValues = new int[str.length()];

        for (int i = 0; i < charList.length; i++) {
            letterValues[i] = alphabets.get(charList[i]) + key;
        }

        char[] decoded = new char[charList.length];

        for (int i = 0; i < str.length(); i++) {
            for (Map.Entry<Character, Integer> pair : alphabets.entrySet()) {
                if (pair.getValue() == letterValues[i] % 26) {
                    decoded[i] = pair.getKey();
                }
            }
        }

        for (char c : decoded) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public static String caesarCypherEnc(String str, int key) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        StringBuilder strBld = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (str.charAt(i) == alphabet[j]) {
                    int decrypted = (j + key) % 26;
                    strBld.append(alphabet[decrypted]);
                }
            }
        }

        return strBld.toString();
    }

    public static String caesarCypherEncryptor(String str, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder strBld = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (str.charAt(i) == alphabet.charAt(j)) {
                    int decrypted = (j + key) % 26;
                    strBld.append(alphabet.charAt(decrypted));
                }
            }
        }

        return strBld.toString();
    }
}
