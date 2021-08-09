package TwoNumberSum;

import java.util.Arrays;

public class TwoNumberSumForIgApp
{
    public static void main(String[] args) {

        int [] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;

        System.out.println(Arrays.toString(twoNumberSum(array, targetSum)));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            if (array[start] + array[end] < targetSum) {
                start++;
            } else if (array[start] + array[end] > targetSum) {
                end--;
            } else if (array[start] + array[end] == targetSum) {
                return new int[] {array[start], array[end]};
            }
        }

        return new int[0];
    }
}
