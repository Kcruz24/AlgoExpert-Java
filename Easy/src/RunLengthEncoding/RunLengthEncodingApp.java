package RunLengthEncoding;

public class RunLengthEncodingApp
{
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAABBCCCCDD";
        String s1 = "aA";

        System.out.println(runLengthEncoding(s1));
    }

    public static String runLengthEncoding(String string) {
        StringBuilder encodedChars = new StringBuilder();
        int currentLength = 1, index = 0;

        for (int i = 0; i < string.length() - 1; i++) {
            index = i + 1;

            if (string.charAt(i) == string.charAt(i + 1) && currentLength < 9) {
                currentLength++;
            } else {
                encodedChars.append(currentLength).append(string.charAt(i));
                currentLength = 1;
            }
        }

        encodedChars.append(currentLength).append(string.charAt(index));

        return encodedChars.toString();
    }
}
