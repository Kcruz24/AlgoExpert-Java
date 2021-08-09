package ThreeNumberSort;

import java.util.Arrays;

public class ThreeNumberSortApp
{
    public static void main(String[] args) {
        int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0, 1, -1};

        System.out.println(Arrays.toString(threeNumberSort(array, order)));
    }

    public static int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        int swapIdx = 0;

        for (int j = 0; j < array.length; j++) {
            // Search for the digit in the order array inside the first array and swap them.
            if (order[0] == array[j]) {
                swap(array, swapIdx, j);
                swapIdx++;
            }
        }

        for (int j = swapIdx; j < array.length; j++) {
            // Search for the digit in the order array inside the first array and swap them.
            if (order[1] == array[j]) {
                swap(array, swapIdx, j);
                swapIdx++;
            }
        }

        return array;
    }

    public static void swap(int[] array, int idxOne, int idxTwo) {
        int temp = array[idxOne];
        array[idxOne] = array[idxTwo];
        array[idxTwo] = temp;
    }
}
