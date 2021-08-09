package ThreeNumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSumApp
{
    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;

        System.out.println(threeNumberSum(array, targetSum));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();

        for (int first = 0; first < array.length; first++) {

            for (int second = first + 1; second < array.length; second++) {

                for (int third = second + 1; third < array.length; third++) {

                    if (array[first] + array[second] + array[third] == targetSum) {
                        Integer[] newResult = {array[first], array[second], array[third]};
                        result.add(newResult);
                    }
                }
            }
        }

        return result;
    }
}
