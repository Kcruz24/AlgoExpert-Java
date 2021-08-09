package BubbleSort;

import java.util.Arrays;

public class BubbleSortApp
{
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    public static int[] bubbleSort(int[] array) {
        for (int lastIdx = array.length - 1; lastIdx > 0; lastIdx--) {
            for (int firstIdx = 0; firstIdx < lastIdx; firstIdx++) {
                if (array[firstIdx] > array[firstIdx + 1]) {
                    swap(array, firstIdx, firstIdx + 1);
                }
            }
        }

        return array;
    }

    public static void swap(int[] array, int idxOne, int idxTwo) {
        if (idxOne == idxTwo)
            return;

        int temp = array[idxOne];
        array[idxOne] = array[idxTwo];
        array[idxTwo] = temp;
    }
}
