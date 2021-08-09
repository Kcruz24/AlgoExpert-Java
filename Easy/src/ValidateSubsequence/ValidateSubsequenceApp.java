package ValidateSubsequence;

import java.util.ArrayList;
import java.util.List;

public class ValidateSubsequenceApp
{
    public static void main(String[] args) {
        /*int[] array1 = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence1 = {5, 1, 22, 25, 6, -1, 8, 10, 12};*/
        int[] array1 = {1, 1, 1, 1, 1};
        int[] sequence1 = {1, 1, 1};

        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();

        for (int j : sequence1)
            sequence.add(j);


        for (int i : array1)
            array.add(i);


        System.out.println(isValidSubsequence(array, sequence));
    }

    // My solution
    // O(n) time | O(n) space
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here

        int count = 0;
        ArrayList<Integer> subsequence = new ArrayList<>();
        int cur = 0;

        while (cur < array.size() && subsequence.size() < sequence.size()) {
            if (sequence.contains(array.get(cur)))
                subsequence.add(array.get(cur));

            cur++;
        }

        for (int i = 0; i < subsequence.size(); i++)
            if (sequence.get(i).equals(subsequence.get(i)))
                count++;

        return count == sequence.size();
    }

    
}
