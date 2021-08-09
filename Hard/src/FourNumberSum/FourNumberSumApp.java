package FourNumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumberSumApp
{
    public static void main(String[] args) {

    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();

        for (int first = 0; first < array.length; first++) {
            for (int second = first + 1; second < array.length; second++) {
                for (int third = second + 1; third < array.length; third++) {
                    for (int fourth = third + 1; fourth < array.length; fourth++) {
                        if (array[first] + array[second] + array[third] + array[fourth] == targetSum) {
                            Integer[] newResult = {array[first], array[second], array[third], array[fourth]};
                            result.add(newResult);
                        }
                    }
                }
            }
        }

        return result;
    }


}
