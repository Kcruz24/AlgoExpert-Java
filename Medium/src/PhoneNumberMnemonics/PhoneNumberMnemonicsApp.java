package PhoneNumberMnemonics;

import java.util.*;

public class PhoneNumberMnemonicsApp
{
    public static void main(String[] args) {
        String test = "444";

        System.out.println(phoneNumberMnemonics(test));
    }

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        String[] currentMnemonic = new String[phoneNumber.length()];
        Arrays.fill(currentMnemonic, "0");

        var result = new ArrayList<String>();
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonic, result);
        return result;
    }

    // O(4^N * N) time | O(4^N * N) space - where N is the length of the phone number
    public static void phoneNumberMnemonicsHelper(int idx, String phoneNumber, String[] currentMnemonic, List<String> result) {
        Map<Character, String[]> keypad = new HashMap<>() {{
            put('1', new String[] {"1"});
            put('2', new String[] {"a", "b", "c"});
            put('3', new String[] {"d", "e", "f"});
            put('4', new String[] {"g", "h", "i"});
            put('5', new String[] {"j", "k", "l"});
            put('6', new String[] {"m", "n", "o"});
            put('7', new String[] {"p", "q", "r", "s"});
            put('8', new String[] {"t", "u", "v"});
            put('9', new String[] {"w", "x", "y", "z"});
            put('0', new String[] {"0"});
        }};

        if (idx == phoneNumber.length()) {
            String mnemonic = String.join("", currentMnemonic);
            result.add(mnemonic);
        } else {
            char digit = phoneNumber.charAt(idx);
            String[] letters = keypad.get(digit);

            for (String letter : letters) {
                currentMnemonic[idx] = letter;
                phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonic, result);
            }
        }
    }
}
