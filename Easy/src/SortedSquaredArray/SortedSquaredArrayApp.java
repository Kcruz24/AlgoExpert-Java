package SortedSquaredArray;

import java.util.Arrays;

public class SortedSquaredArrayApp
{
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 8, 9};

        System.out.println(Arrays.toString(sortedSquaredArray(array)));
    }

    public static int[] sortedSquaredArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= array[i];
        }
        Arrays.sort(array);

        return array;
    }
}
