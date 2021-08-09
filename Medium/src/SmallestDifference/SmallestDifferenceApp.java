package SmallestDifference;

import java.util.Arrays;

public class SmallestDifferenceApp
{
    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};

        System.out.println(Arrays.toString(smallestDifference(arrayOne, arrayTwo)));

    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int idxOne = 0;
        int idxTwo = 0;
        int[] smallestPair = new int[2];
        int smallest = Integer.MAX_VALUE;
        int current;

        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
            int digit1 = arrayOne[idxOne];
            int digit2 = arrayTwo[idxTwo];

            if (arrayOne[idxOne] < arrayTwo[idxTwo]) {
                current = arrayTwo[idxTwo] - arrayOne[idxOne];
                idxOne++;
            } else if (arrayTwo[idxTwo] < arrayOne[idxOne]) {
                current = arrayOne[idxOne] - arrayTwo[idxTwo];
                idxTwo++;
            } else {
                return new int[] {arrayOne[idxOne], arrayTwo[idxTwo]};
            }

            if (current < smallest) {
                smallest = current;
                smallestPair = new int[] {digit1, digit2};
            }
        }

        return smallestPair;
    }
}
