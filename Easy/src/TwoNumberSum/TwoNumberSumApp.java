package TwoNumberSum;

import java.util.Arrays;

public class TwoNumberSumApp
{
    public static void main(String[] args) {
        int[] testArr = {3, 5, -4, 8, 11, 1, -1, 6};
        int[] output = twoNumberSum(testArr, 10);

        System.out.println(Arrays.toString(output));

        //twoNumberSum(testArr, 10);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.

        for(int j = 0; j < array.length;j++)
        {
            for (int i = 0; i < j; i++)
            {
                if (array[j] + array[i] == targetSum)
                    return new int[] {array[j], array[i]};
            }
        }

        return new int[0];
    }
}
